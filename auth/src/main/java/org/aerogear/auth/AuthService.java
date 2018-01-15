package org.aerogear.auth;

import org.aerogear.auth.credentials.ICredential;
import org.aerogear.auth.impl.AuthenticatorFactory;

import java.security.Principal;

/**
 * Entry point for authenticating users.
 */
public class AuthService {

    /**
     * Authentication service singleton.
     */
    private static AuthService INSTANCE;

    /**
     * Authentication service config.
     */
    private final AuthServiceConfig config;

    /**
     * Instantiates a new AuthService object
     * @param config Authentication Service configuration
     */
    private AuthService(final AuthServiceConfig config) {
        this.config = config;
    }

    /**
     * Log in the user with the given credential.
     *
     * @param username The username
     * @param credentials the credential
     * @return a user principal
     * @throws AuthenticationException throws if the authentication fails
     */
    public Principal login(final String username, final ICredential credentials) throws AuthenticationException {
        return AuthenticatorFactory.getAuthenticator(credentials).authenticate(username, credentials);
    }

    /**
     * Log out the given principal.
     *
     * @param principal principal to be logged out
     */
    public void logout(Principal principal) {
        AuthenticatorFactory.getAuthenticator(principal).logout(principal);
    }

    /**
     * Returns the authentication service singleton.
     *
     * @return the authentication service singleton
     */
    public static synchronized AuthService getInstance() {
        if (INSTANCE == null) {
            // TODO: load the configurations from core and pass it here
            INSTANCE = new AuthService(null);
        }

        return INSTANCE;
    }

}
