package org.aerogear.auth;


import org.aerogear.auth.credentials.OIDCCredentials;

public interface IKeycloakUserPrincipal extends IUserPrincipal {
    /**
     * Returns the session token.
     * @return the session token
     */
    OIDCCredentials getIdentityToken();

    OIDCCredentials getAccessToken();

    OIDCCredentials getRefreshToken();
}
