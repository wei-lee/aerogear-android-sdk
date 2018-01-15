package org.aerogear.auth.utils;

import org.aerogear.auth.credentials.TokenCredentials;

/**
 * Saves, retrieves and delete a token.
 */
public class TokenPersistor {
    private TokenPersistor() {
    }

    public static TokenCredentials load() {
        throw new IllegalStateException("Not yet implemented");
    }

    /**
     * Saves a token
     * @param token token to be saved
     */
    public static void save(TokenCredentials token) {
        throw new IllegalStateException("Not yet implemented");
    }

    /**
     * Deletes a token
     * @param token token to be deleted
     */
    public static void delete(TokenCredentials token) {
        throw new IllegalStateException("Not yet implemented");
    }
}
