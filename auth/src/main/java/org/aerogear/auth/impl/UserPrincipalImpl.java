package org.aerogear.auth.impl;

import org.aerogear.auth.IRole;
import org.aerogear.auth.IUserPrincipal;

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

    private UserPrincipalImpl(final String username, Map<String, IRole> roles, final AbstractAuthenticator authenticator) {
        super(authenticator);
        this.username = username;
        this.roles = Collections.unmodifiableMap(roles);
    }

    /**
     * Builds and return a UserPrincipalImpl object
     */
    static class Builder {
        private String username;
        private Map<String, IRole> roles = new HashMap<>();
        private AbstractAuthenticator authenticator;

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

        UserPrincipalImpl build() {
            return new UserPrincipalImpl(this.username, this.roles, this.authenticator);
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
}
