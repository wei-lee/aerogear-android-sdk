package org.aerogear.auth;

import org.aerogear.auth.credentials.TokenCredentials;

import java.security.Principal;

/**
 * Public interface for user principals.
 */
public interface IUserPrincipal extends Principal {

    /**
     * Checks if the user has the specified role.
     * @param role role to be checked
     * @return true or false
     */
    boolean hasRole(IRole role);

    /**
     * Returns the username
     * @return the username
     */
    String getName();

    /**
     * Returns the session token.
     * @return the session token
     */
    TokenCredentials getToken();
}
