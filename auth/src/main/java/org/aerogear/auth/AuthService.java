package org.aerogear.auth;

import org.aerogear.auth.credentials.ICredential;
import org.aerogear.auth.impl.AuthenticatorFactory;

import java.security.Principal;

/**
 * Entry point for authenticating users.
 */
public class AuthService {

    private final AuthServiceConfig config;

    /**
     * Instantiates a new AuthService object
     * @param config Authentication Service configuration
     */
    public AuthService(final AuthServiceConfig config) {
        this.config = config;
    }

    public Principal login(final String username, final ICredential credentials) throws AuthenticationException {
        return AuthenticatorFactory.getAuthenticator(credentials).authenticate(username, credentials);
    }
}
