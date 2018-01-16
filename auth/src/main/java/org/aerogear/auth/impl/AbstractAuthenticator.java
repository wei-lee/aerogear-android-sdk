package org.aerogear.auth.impl;

import org.aerogear.auth.AuthServiceConfig;
import org.aerogear.auth.credentials.ICredential;

import java.security.Principal;
import java.util.concurrent.Future;

/**
 * Base class for all authenticators
 */
public class AbstractAuthenticator {

    private final AuthServiceConfig config;

    AbstractAuthenticator(final AuthServiceConfig config) {
        this.config = config;
    }

    /**
     * This method must be overridden with the custom authentication for the given credential.
     *
     * @param username username to be authenticated
     * @param credential user credential
     * @return the authenticated principal
     */
    public Future<Principal> authenticate(final String username, final ICredential credential) {
        throw new IllegalStateException("Not implemented");
    }

    /**
     * Logout the given principal
     * @param principal principal to be log out
     */
    public Future<Void> logout(final Principal principal) {
        throw new IllegalStateException("Not implemented");
    }

    /**
     * Returns the authentication service configuration
     * @return the authentication service configuration
     */
    protected AuthServiceConfig getConfig() {
        return config;
    }
}
