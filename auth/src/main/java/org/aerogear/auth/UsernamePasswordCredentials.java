package org.aerogear.auth;

import java.util.Arrays;

public class UsernamePasswordCredentials implements ICredential {

    private final String username;
    private final char[] password;

    public UsernamePasswordCredentials(final String username, final char[] password) {
        this.username = username;
        this.password = Arrays.copyOf(password, password.length);
    }

    public String getUsername() {
        return username;
    }

    public char[] getPassword() {
        return password;
    }
}
