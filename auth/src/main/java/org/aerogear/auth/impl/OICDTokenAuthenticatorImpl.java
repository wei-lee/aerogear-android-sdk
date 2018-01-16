package org.aerogear.auth.impl;

import org.aerogear.auth.AbstractAuthenticator;
import org.aerogear.auth.AuthServiceConfig;

/**
 * Authenticates token credentials
 */
public class OICDTokenAuthenticatorImpl extends AbstractAuthenticator {
    public OICDTokenAuthenticatorImpl(final AuthServiceConfig config) {
        super(config);
    }
}
