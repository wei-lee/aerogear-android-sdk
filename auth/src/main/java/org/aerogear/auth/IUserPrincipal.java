package org.aerogear.auth;

import java.security.Principal;

public interface IUserPrincipal extends Principal {
    boolean hasRole(IRole role);

    String getName();
}
