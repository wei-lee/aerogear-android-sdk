package org.aerogear.auth;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/**
 * This class represent an authenticated username
 */
public class User {
    private final String username;
    private final Map<String, IRole> roles;

    private User(final String username, Map<String, IRole> roles) {
        this.username = username;
        this.roles = Collections.unmodifiableMap(roles);
    }

    /**
     * Builds and return a User object
     */
    public static class Builder {
        private String username;
        private Map<String, IRole> roles;

        public Builder() {
        }

        public Builder withUsername(final String username) {
            this.username = username;
            return this;
        }

        public Builder withRole(final IRole role) {
            this.roles.put(role.getRoleID(), role);
            return this;
        }

        public Builder withRoles(final IRole[] roles) {
            return withRoles(Arrays.asList(roles));
        }

        public Builder withRoles(final Collection<IRole> roles) {

            for (IRole role : roles) {
                this.withRole(role);
            }

            return this;
        }

        public User build() {
            return new User(this.username, this.roles);
        }
    }

    /**
     * Returns <code>true</code> if the user has the passed in role.
     * @return true or false
     */
    public boolean hasRole(IRole role) {
        return roles.containsKey(role.getRoleID());
    }
}
