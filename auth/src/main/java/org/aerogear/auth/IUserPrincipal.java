package org.aerogear.auth;

import org.aerogear.auth.credentials.TokenCredentials;

import java.security.Principal;

public interface IUserPrincipal extends Principal {
    boolean hasRole(IRole role);

    String getName();

    TokenCredentials getToken();
}
