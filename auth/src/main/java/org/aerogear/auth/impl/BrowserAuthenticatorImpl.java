package org.aerogear.auth.impl;

import org.aerogear.auth.AuthServiceConfig;
import org.aerogear.auth.credentials.ICredential;

import java.security.Principal;

/**
 * Authenticates the user by opening a browser window asking for credentials.
 */
public class BrowserAuthenticatorImpl extends OICDTokenAuthenticatorImpl {

    public BrowserAuthenticatorImpl(final AuthServiceConfig config) {
        super(config);
    }

    /**
     * @param credential Ignored.
     * @return authenticated Principal
     */
    @Override
    public Principal authenticate(final ICredential credential) {
        throw new IllegalStateException("Not implemented");
    }
}
