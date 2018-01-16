package org.aerogear.auth;

import org.aerogear.auth.credentials.ICredential;
import org.aerogear.auth.impl.AuthenticatorFactory;

import java.security.Principal;
import java.util.concurrent.Future;

/**
 * Entry point for authenticating users.
 */
public class AuthService {

    /**
     * Authentication service singleton.
     */
    private static AuthService INSTANCE;

    private final AuthenticatorFactory authenticatorFactory;

    /**
     * Instantiates a new AuthService object
     * @param config Authentication Service configuration
     */
    private AuthService(final AuthServiceConfig config) {
        this.authenticatorFactory = new AuthenticatorFactory(config);
    }

    /**
     * Log in the user with the given credential. Flow to be used to authenticate the user is automatically
     * selected by analysing the received credentials. If the credentials are null,
     * the browser will be open asking for authentication
     *
     * The login will be asynchronous.
     *
     * @param username The username
     * @param credentials the credential
     * @return a user principal
     */
    public Future<Principal> login(final String username, final ICredential credentials) {
        return authenticatorFactory.getAuthenticator(credentials).authenticate(username, credentials);
    }

    /**
     * Log out the given principal.
     * The logout will be asynchronous.
     *
     * @param principal principal to be logged out
     */
    public Future<Void> logout(Principal principal) {
        return authenticatorFactory.getAuthenticator(principal).logout(principal);
    }

    /**
     * Returns the authentication service singleton.
     *
     * @return the authentication service singleton
     */
    public static synchronized AuthService getInstance() {
        if (INSTANCE == null) {
            // FIXME: load the configurations from core and pass it here
            INSTANCE = new AuthService(null);
        }

        return INSTANCE;
    }

}
