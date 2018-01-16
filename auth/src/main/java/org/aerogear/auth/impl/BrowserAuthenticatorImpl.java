package org.aerogear.auth.impl;

import org.aerogear.auth.AuthServiceConfig;
import org.aerogear.auth.credentials.ICredential;

import java.security.Principal;
import java.util.concurrent.Future;

/**
 * Authenticates the user by opening a browser window asking for credentials.
 */
public class BrowserAuthenticatorImpl extends TokenAuthenticatorImpl {

    public BrowserAuthenticatorImpl(final AuthServiceConfig config) {
        super(config);
    }

    /**
     *
     * @param username Ignored.
     * @param credential Ignored.
     * @return authenticated Principal
     */
    @Override
    public Future<Principal> authenticate(final String username, final ICredential credential) {
        throw new IllegalStateException("Not implemented");
    }
}
