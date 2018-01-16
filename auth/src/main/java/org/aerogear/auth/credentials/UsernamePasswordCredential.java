package org.aerogear.auth.credentials;

public class UsernamePasswordCredential implements ICredential {
    private final String username;
    private final String password;

    public UsernamePasswordCredential(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
