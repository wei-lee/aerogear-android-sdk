package org.aerogear.auth.credentials;

import java.util.Arrays;

/**
 * Credentials for token based authentication
 */
public final class TokenCredentials implements ICredential {
    private final byte[] tokenValue;

    public TokenCredentials(final byte[] tokenValue) {
        this.tokenValue = Arrays.copyOf(tokenValue, tokenValue.length);

        parseToken();
    }

    /**
     * Parses the raw token bytes to extract token data (expiration, issue time, etc.)
     */
    private void parseToken() {

    }

    /**
     * Returns the raw token bytes
     * @return
     */
    public byte[] getRaw() {
        return Arrays.copyOf(tokenValue, tokenValue.length);
    }

    /**
     * Returns whether this token is expired or not.
     * @return <code>true</code> if expired.
     */
    public boolean isExpired() {
        throw new IllegalStateException("Not yet implemented");
    }
}
