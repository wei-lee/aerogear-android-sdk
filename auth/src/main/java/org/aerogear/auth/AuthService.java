package org.aerogear.auth;

import org.aerogear.auth.credentials.ICredential;
import org.aerogear.auth.impl.AuthenticatorFactory;

import java.security.Principal;

/**
 * Entry point for authenticating users.
 */
public class AuthService {


    private static AuthService INSTANCE;

    private final AuthServiceConfig config;

    /**
     * Instantiates a new AuthService object
     * @param config Authentication Service configuration
     */
    private AuthService(final AuthServiceConfig config) {
        this.config = config;
    }

    public Principal login(final String username, final ICredential credentials) throws AuthenticationException {
        return AuthenticatorFactory.getAuthenticator(credentials).authenticate(username, credentials);
    }

    public void logout(Principal principal) {
        AuthenticatorFactory.getAuthenticator(principal).logout(principal);
    }

    public static synchronized AuthService getInstance() {
        if (INSTANCE == null) {
            // TODO: load the configurations from core and pass it here
            INSTANCE = new AuthService(null);
        }

        return INSTANCE;
    }

}
