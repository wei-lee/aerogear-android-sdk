package org.aerogear.auth.impl;

import org.aerogear.auth.IUserPrincipal;

abstract class AbstractPrincipal implements IUserPrincipal {
    private final AbstractAuthenticator authenticator;

    AbstractPrincipal (AbstractAuthenticator authenticator) {
        this.authenticator = authenticator;
    }

    public AbstractAuthenticator getAuthenticator() {
        return authenticator;
    }
}
