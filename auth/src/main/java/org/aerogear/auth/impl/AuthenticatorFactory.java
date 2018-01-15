package org.aerogear.auth.impl;

import org.aerogear.auth.credentials.ICredential;
import org.aerogear.auth.credentials.PasswordCredentials;
import org.aerogear.auth.credentials.TokenCredentials;

public class AuthenticatorFactory {
    private AuthenticatorFactory() {
    }

    public static AbstractAuthenticator getAuthenticator(final ICredential credentials) {
        if (credentials instanceof PasswordCredentials) {
            return new PasswordAuthenticatorImpl();
        }

        if (credentials instanceof TokenCredentials) {
            return new TokenAuthenticatorImpl();
        }

        throw new IllegalArgumentException("Uknown credential type" + credentials.getClass().getName());
    }
}
