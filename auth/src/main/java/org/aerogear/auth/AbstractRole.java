package org.aerogear.auth;

/**
 * Base class for roles pojos.
 */
abstract class AbstractRole implements IRole {

    private final String roleID;
    private final String roleName;

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
