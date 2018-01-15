package org.aerogear.auth.impl;

import org.aerogear.auth.credentials.ICredential;
import org.aerogear.auth.credentials.PasswordCredentials;
import org.aerogear.auth.credentials.TokenCredentials;

import java.security.Principal;

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

        throw new IllegalArgumentException("Invalid credential type (" + credentials.getClass().getName() + ")");
    }

    public static AbstractAuthenticator getAuthenticator(final Principal principal) {
        if (principal instanceof AbstractPrincipal) {
            ((AbstractPrincipal) principal).getAuthenticator().logout(principal);
        }

        throw new IllegalArgumentException("Invalid principal type " + (principal.getClass().getName()));
    }
}
