package org.aerogear.auth;

import java.util.Arrays;

public class TokenCredentials {
    private final byte[] tokenValue;

    public TokenCredentials(final byte[] tokenValue) {
        this.tokenValue = Arrays.copyOf(tokenValue, tokenValue.length);
    }

    public byte[] getTokenValue() {
        return Arrays.copyOf(tokenValue, tokenValue.length);
    }
}
