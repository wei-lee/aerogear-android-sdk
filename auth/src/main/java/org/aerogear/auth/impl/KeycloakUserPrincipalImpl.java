package org.aerogear.auth.impl;


import org.aerogear.auth.AbstractAuthenticator;
import org.aerogear.auth.IKeycloakUserPrincipal;
import org.aerogear.auth.IRole;
import org.aerogear.auth.credentials.OIDCCredentials;

import java.util.Map;

public class KeycloakUserPrincipalImpl extends UserPrincipalImpl implements IKeycloakUserPrincipal {

    private OIDCCredentials identityToken;
    private OIDCCredentials accessToken;
    private OIDCCredentials refreshToken;


    protected KeycloakUserPrincipalImpl(final String username,
                                final String email,
                                final Map<String, IRole> roles,
                                final OIDCCredentials identityToken,
                                final OIDCCredentials accessToken,
                                final OIDCCredentials refreshToken,
                                final AbstractAuthenticator authenticator) {
        super(username, email, roles, authenticator);
    }

    public static class Builder extends UserPrincipalImpl.Builder {
        protected OIDCCredentials identityToken;
        protected OIDCCredentials accessToken;
        protected OIDCCredentials refreshToken;

        Builder withIdentityToken(OIDCCredentials identityToken) {
            this.identityToken = identityToken;
            return this;
        }

        Builder withAccessToken(OIDCCredentials accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        Builder withRefreshToken(OIDCCredentials refreshToken) {
            this.refreshToken = refreshToken;
            return this;
        }

        KeycloakUserPrincipalImpl build() {
            return new KeycloakUserPrincipalImpl(
                    super.username,
                    super.email,
                    super.roles,
                    this.identityToken,
                    this.accessToken,
                    this.refreshToken,
                    super.authenticator);
        }

    }

    @Override
    public OIDCCredentials getIdentityToken() {
        return identityToken;
    }

    @Override
    public OIDCCredentials getAccessToken() {
        return accessToken;
    }

    @Override
    public OIDCCredentials getRefreshToken() {
        return refreshToken;
    }

}
