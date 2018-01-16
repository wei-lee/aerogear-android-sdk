package org.aerogear.auth.impl;

import org.aerogear.auth.AuthServiceConfig;
import org.aerogear.auth.CredentialsType;
import org.aerogear.auth.credentials.ICredential;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * Factory for authentication handlers.
 */
public final class AuthenticatorFactory {

    private final AuthServiceConfig config;

    private final Map<CredentialsType, AbstractAuthenticator> authenticatorsCache = new HashMap<>();

    /**
     * Instantiates a new AuthenticatorFactory object and configures it.
     * @param config authentication service configuration
     */
    public AuthenticatorFactory(final AuthServiceConfig config) {
        this.config = config;
        this.authenticatorsCache.put(CredentialsType.BROWSER, new BrowserAuthenticatorImpl(config));
        this.authenticatorsCache.put(CredentialsType.TOKEN, new TokenAuthenticatorImpl(config));
    }

    /**
     * Returns the authenticator for the given credentials.
     * If credentials are null, browswer authenticator is returned.
     *
     * @param credentials credentials to be authenticated.
     * @return appropriate authenticator
     */
    public AbstractAuthenticator getAuthenticator(final ICredential credentials) {
        if (credentials == null) {
            // No credentials provided, browser based authentication needed
            return authenticatorsCache.get(CredentialsType.BROWSER);
        }

        return getAuthenticator(credentials.getType());
    }

    /**
     * Returns the authenticator that was used to authenticate the given principal.
     *
     * @param principal
     * @return the authenticator that was used to authenticate the given principal
     */
    public AbstractAuthenticator getAuthenticator(final Principal principal) {
        if (principal instanceof AbstractPrincipal) {
            return getAuthenticator(((AbstractPrincipal) principal).getCredentialsType());
        }

        throw new IllegalArgumentException("Invalid principal type " + (principal.getClass().getName()));
    }

    public AbstractAuthenticator getAuthenticator(final CredentialsType credentialsType) {
        return authenticatorsCache.get(credentialsType);
    }
}
