package org.aerogear.auth;

import org.aerogear.auth.credentials.ICredential;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Authenticate the user by executing the authentication chain.
 * Stops at the first successful login or at the first failing mandatory authenticator.
 * At list one authenticator must be successful.
 */
public class AuthenticationChain {

    private static ExecutorService EXECUTOR = Executors.newFixedThreadPool(10);
    private final List<AuthenticationRing> chain;

    private static class AuthenticationRing {
        private final AbstractAuthenticator authenticator;
        private final boolean mandatory;

        public AuthenticationRing(final AbstractAuthenticator authenticator, final boolean mandatory) {
            this.authenticator = authenticator;
            this.mandatory = mandatory;
        }

        public AuthenticationRing(final AbstractAuthenticator authenticator) {
            this.authenticator = authenticator;
            this.mandatory = false;
        }

        public boolean isMandatory() {
            return mandatory;
        }

        public AbstractAuthenticator getAuthenticator() {
            return authenticator;
        }

        public Principal authenticate(ICredential credential) throws AuthenticationException {
            try {
                return authenticator.authenticate(credential);
            } catch (AuthenticationException ae) {
                if (isMandatory()) {
                    throw new AuthenticationException(ae);
                }
            }

            return null;
        }
    }

    public static class Builder {
        private List<AuthenticationRing> chain = new ArrayList<>();

        private Builder(){
        }

        public Builder with(AbstractAuthenticator authenticator) {
            chain.add(new AuthenticationRing(authenticator));
            return this;
        }

        public Builder with(AbstractAuthenticator authenticator, boolean mandatory) {
            chain.add(new AuthenticationRing(authenticator, mandatory));
            return this;
        }

        public AuthenticationChain build() {
            return new AuthenticationChain(this.chain);
        }

    }

    private AuthenticationChain(final List<AuthenticationRing> chain) {
        this.chain = chain;
    }

    public Future<Principal> authenticate(final ICredential credential) {

        Callable<Principal> authenticateCallable = new Callable<Principal>() {
            @Override
            public Principal call() throws Exception {
                for(AuthenticationRing ring : chain) {
                    Principal principal = ring.authenticate(credential);
                    if (principal != null) {
                        return principal;
                    }

                    if (ring.isMandatory()) {
                        throw new AuthenticationException("Authentication failed");
                    }
                }

                throw new AuthenticationException("Authentication failed");
            }
        };

        return EXECUTOR.submit(authenticateCallable);
    }

    public Future<Void> logout(final Principal principal) {

        Callable<Void> authenticateCallable = new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                if (principal instanceof AbstractPrincipal) {
                    ((AbstractPrincipal) principal).getAuthenticator().logout(principal);
                }
                return null;
            }
        };

        return EXECUTOR.submit(authenticateCallable);
    }


    public static Builder newChain() {
        return new Builder();
    }
}
