package org.aerogear.auth.impl;

import org.aerogear.auth.AuthServiceConfig;

/**
 * Authenticates token credentials
 */
public class TokenAuthenticatorImpl extends AbstractAuthenticator{
    public TokenAuthenticatorImpl(final AuthServiceConfig config) {
        super(config);
    }
}
