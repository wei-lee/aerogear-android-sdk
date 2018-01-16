package org.aerogear.auth;

import org.aerogear.auth.credentials.OIDCCredentials;

import java.security.Principal;
import java.util.Collection;

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

    Collection<IRole> getRoles();
}
