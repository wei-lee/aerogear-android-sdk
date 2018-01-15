package org.aerogear.auth.credentials;

import java.util.Arrays;

/**
 * Credentials for token based authentication
 */
public final class TokenCredentials implements ICredential {
    private final byte[] tokenValue;

    public TokenCredentials(final byte[] tokenValue) {
        this.tokenValue = Arrays.copyOf(tokenValue, tokenValue.length);
    }

    public byte[] getTokenValue() {
        return Arrays.copyOf(tokenValue, tokenValue.length);
    }
}
