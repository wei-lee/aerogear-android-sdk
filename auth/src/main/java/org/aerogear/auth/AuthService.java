package org.aerogear.auth;

/**
 * Entry point for authenticating users
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

    public User login(final ICredential[] credentials) throws AuthenticationException {
        throw new AuthenticationException("Not implemented");
    }
}
