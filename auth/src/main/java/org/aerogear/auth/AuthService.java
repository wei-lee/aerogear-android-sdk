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
    public AuthService(AuthServiceConfig config) {
        this.config = config;
    }

    public User login(final String username, final String password) throws AuthenticationException {
        throw new AuthenticationException("Not implemented");
    }
}
