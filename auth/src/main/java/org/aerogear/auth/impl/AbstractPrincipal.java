package org.aerogear.auth.impl;

import org.aerogear.auth.CredentialsType;
import org.aerogear.auth.IUserPrincipal;

/**
 * Base class for aerogear principals
 */
abstract class AbstractPrincipal implements IUserPrincipal {

    /**
     * The authenticator that was used to authenticate this principal.
     */
    private final CredentialsType credentialsType;

    /**
     * Type of credentials used to authenticate this user.
     *
     * @param credentialsType the type of credentials
     */
    AbstractPrincipal (CredentialsType credentialsType) {
        if (credentialsType == null) {
            throw new NullPointerException("Credentials type can't be null");
        }

        this.credentialsType = credentialsType;
    }

    /**
     * Returns the authenticator used to authenticate the principal.
     *
     * @return the authenticator used to authenticate the principal
     */
    public CredentialsType getCredentialsType() {
        return credentialsType;
    }
}
