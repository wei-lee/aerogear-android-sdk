package org.aerogear.auth.credentials;

import java.util.Arrays;

/**
 * Credentials for password based authentication
 */
public final class PasswordCredentials implements ICredential {

    private final char[] password;

    public PasswordCredentials(final char[] password) {
        this.password = Arrays.copyOf(password, password.length);
    }

    public char[] getPassword() {
        return Arrays.copyOf(password, password.length);
    }
}
