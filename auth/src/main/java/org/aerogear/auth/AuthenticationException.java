package org.aerogear.auth;

/**
 * Exception thrown when an error occurres authenticating a user.
 */
public class AuthenticationException extends Exception {

    public AuthenticationException(final String message) {
        super(message);
    }

    public AuthenticationException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
