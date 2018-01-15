package org.aerogear.auth.impl;

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
    private final String username;
    private final Map<String, IRole> roles;
    private final TokenCredentials token;

    private UserPrincipalImpl(final String username, Map<String, IRole> roles, final TokenCredentials token, final AbstractAuthenticator authenticator) {
        super(authenticator);
        this.username = username;
        this.roles = Collections.unmodifiableMap(roles);
        this.token = token;
    }

    /**
     * Builds and return a UserPrincipalImpl object
     */
    static class Builder {
        private String username;
        private Map<String, IRole> roles = new HashMap<>();
        private AbstractAuthenticator authenticator;
        private TokenCredentials token;

        public Builder() {
        }

        Builder withUsername(final String username) {
            this.username = username;
            return this;
        }

        Builder withRole(final IRole role) {
            this.roles.put(role.getRoleID(), role);
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

        Builder withAuthenticator(AbstractAuthenticator authenticator) {
            this.authenticator = authenticator;
            return this;
        }

        Builder withToken(TokenCredentials token) {
            this.token = token;
            return this;
        }

        UserPrincipalImpl build() {
            return new UserPrincipalImpl(this.username, this.roles, this.token, this.authenticator);
        }
    }

    /**
     * Returns <code>true</code> if the user has the passed in role.
     * @return true or false
     */
    @Override
    public boolean hasRole(IRole role) {
        return roles.containsKey(role.getRoleID());
    }

    @Override
    public String getName() {
        return username;
    }

    @Override
    public TokenCredentials getToken() {
        return token;
    }
}
