package org.aerogear.auth;

/**
 * Base class for roles pojos.
 */
abstract class AbstractRole implements IRole {

    /**
     * Unique identifier for this role.
     */
    private final String roleID;

    /**
     * Role friendly name
     */
    private final String roleName;

    /**
     * Builds a role object
     * @param roleID Role unique id
     * @param roleName Role friendly name
     */
    AbstractRole(final String roleID, final String roleName) {
        this.roleID = roleID;
        this.roleName = roleName;
    }

    @Override
    public String getRoleID() {
        return this.roleID;
    }

    @Override
    public String getRoleName() {
        return this.roleName;
    }
}
