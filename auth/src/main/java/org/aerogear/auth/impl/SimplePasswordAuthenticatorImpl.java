package org.aerogear.auth.impl;

import org.aerogear.auth.AbstractAuthenticator;
import org.aerogear.auth.AuthenticationException;
import org.aerogear.auth.credentials.ICredential;
import org.aerogear.auth.credentials.UsernamePasswordCredential;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

public class SimplePasswordAuthenticatorImpl extends AbstractAuthenticator {
    private Map<String, String> users = new HashMap<>();

    public SimplePasswordAuthenticatorImpl() {
        super(null);
    }

    public SimplePasswordAuthenticatorImpl addUser(final String username, final String password) {
        this.users.put(username, password);
        return this;
    }

    @Override
    public Principal authenticate(ICredential credential) throws AuthenticationException {
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential upc = (UsernamePasswordCredential) credential;
            if (users.containsKey(upc.getUsername()) && users.get(upc.getUsername()).equals(upc.getPassword())) {
                return UserPrincipalImpl
                        .newUser()
                        .withUsername(upc.getUsername())
                        .withAuthenticator(this)
                        .build();
            }
        }
        return null;
    }
}
