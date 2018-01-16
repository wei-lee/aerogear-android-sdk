package org.aerogear.auth.impl;

import org.aerogear.auth.CredentialsType;
import org.aerogear.auth.IRole;
import org.aerogear.auth.credentials.TokenCredentials;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represent an authenticated user
 */
public class UserPrincipalImpl extends AbstractPrincipal {

    /**
     * The username of the principal.
     */
    private final String username;

    private final String email;

    /**
     * Roles associated with this principal.
     */
    private final Map<String, IRole> roles;

    /**
     * Authentication token associated with this principal.
     */
    private final TokenCredentials identityToken;
    private final TokenCredentials accessToken;
    private final TokenCredentials refreshToken;

    /**
     * Builds a new UserPrincipalImpl object
     *
     * @param username the username of the authenticated user
     * @param email the email of the authenticated user
     * @param roles roles assigned to the user
     * @param identityToken identityToken as returned by keycloak
     * @param accessToken accessToken as returned by keycloak
     * @param refreshToken refreshToken as returned by keycloak
     * @param credentialsType the authenticator that authenticated this user
     */
    private UserPrincipalImpl(final String username,
                              final String email,
                              final Map<String, IRole> roles,
                              final TokenCredentials identityToken,
                              final TokenCredentials accessToken,
                              final TokenCredentials refreshToken,
                              final CredentialsType credentialsType) {
        super(credentialsType);
        this.username = username;
        this.email = email;
        this.roles = Collections.unmodifiableMap(new HashMap<String, IRole>(roles));
        this.identityToken = identityToken;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    /**
     * Builds and return a UserPrincipalImpl object
     */
    static class Builder {
        private String username;
        private String email;
        private Map<String, IRole> roles = new HashMap<>();
        private CredentialsType credentialsType;
        private TokenCredentials identityToken;
        private TokenCredentials accessToken;
        private TokenCredentials refreshToken;

        public Builder() {
        }

        Builder withUsername(final String username) {
            this.username = username;
            return this;
        }

        Builder withEmail(final String email) {
            this.email = email;
            return this;
        }

        Builder withRole(final IRole role) {
            this.roles.put(role.getRoleName(), role);
            return this;
        }

        Builder withRoles(final IRole[] roles) {
            return withRoles(Arrays.asList(roles));
        }

        Builder withRoles(final Collection<IRole> roles) {

            for (IRole role : roles) {
                this.withRole(role);
            }

            return this;
        }

        Builder withAuthenticator(CredentialsType credentialsType) {
            this.credentialsType = credentialsType;
            return this;
        }

        Builder withIdentityToken(TokenCredentials identityToken) {
            this.identityToken = identityToken;
            return this;
        }

        Builder withAccessToken(TokenCredentials accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        Builder withRefreshToken(TokenCredentials refreshToken) {
            this.refreshToken = refreshToken;
            return this;
        }

        UserPrincipalImpl build() {
            return new UserPrincipalImpl(
                    this.username,
                    this.email,
                    this.roles,
                    this.identityToken,
                    this.accessToken,
                    this.refreshToken,
                    this.credentialsType);
        }
    }

    /**
     * Returns <code>true</code> if the user has the passed in role.
     * @return true or false
     */
    @Override
    public boolean hasRole(final IRole role) {
        return roles.containsKey(role.getRoleName());
    }

    @Override
    public String getName() {
        return username;
    }

    @Override
    public TokenCredentials getIdentityToken() {
        return identityToken;
    }

    @Override
    public TokenCredentials getAccessToken() {
        return accessToken;
    }

    @Override
    public TokenCredentials getRefreshToken() {
        return refreshToken;
    }

    @Override
    public Collection<IRole> getRoles() {
        return roles.values();
    }
}
