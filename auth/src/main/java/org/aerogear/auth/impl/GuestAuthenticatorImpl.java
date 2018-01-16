package org.aerogear.auth.impl;

import org.aerogear.auth.AbstractAuthenticator;
import org.aerogear.auth.AuthenticationException;
import org.aerogear.auth.IRole;
import org.aerogear.auth.credentials.ICredential;

import java.security.Principal;
import java.util.Arrays;

public class GuestAuthenticatorImpl extends AbstractAuthenticator {

    private final String guestUser;
    private final IRole[] roles;

    public GuestAuthenticatorImpl(final String guestUser, final IRole[] roles) {
        super(null);
        this.guestUser = guestUser;
        if (roles == null) {
            this.roles = new IRole[0];
        }
        else {
            this.roles = Arrays.copyOf(roles, roles.length);
        }
    }

    public Principal authenticate(final ICredential credential) throws AuthenticationException {
        return UserPrincipalImpl
                .newUser()
                .withAuthenticator(this)
                .withUsername(guestUser)
                .withRoles(roles)
                .build();
    }

    @Override
    public void logout(Principal principal) {
        return;
    }
}
