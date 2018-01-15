package org.aerogear.auth.impl;

import org.aerogear.auth.IUserPrincipal;

/**
 * Base class for aerogear principals
 */
abstract class AbstractPrincipal implements IUserPrincipal {
    private final AbstractAuthenticator authenticator;

    /**
     * Authenticator used to authenticate the principal.
     *
     * @param authenticator the authenticator
     */
    AbstractPrincipal (AbstractAuthenticator authenticator) {
        this.authenticator = authenticator;
    }

    /**
     * Returns the authenticator used to authenticate the principal.
     *
     * @return the authenticator used to authenticate the principal
     */
    public AbstractAuthenticator getAuthenticator() {
        return authenticator;
    }
}
