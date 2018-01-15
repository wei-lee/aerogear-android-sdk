package org.aerogear.auth.impl;

import org.aerogear.auth.AuthenticationException;
import org.aerogear.auth.credentials.ICredential;

import java.security.Principal;

/**
 * Base class for all authenticators
 */
public class AbstractAuthenticator {

    /**
     * This method must be overridden with the custom authentication for the given credential.
     *
     * @param username username to be authenticated
     * @param credential user credential
     * @return the authenticated principal
     * @throws AuthenticationException
     */
    public Principal authenticate(final String username, ICredential credential) throws AuthenticationException {
        throw new IllegalStateException("Not implemented");
    }

    /**
     * Logout the given principal
     * @param principal principal to be log out
     */
    public void logout(Principal principal) {
        throw new IllegalStateException("Not implemented");
    }
}
