package com.kevinbedoya.accentra.domain.model.enums;

public enum SystemUserRole {
    /**
     * Has all possible permissions across the entire system.
     */
    SUPER_ADMIN,

    /**
     * Can manage users and organizations, but has some restrictions.
     */
    ADMIN_SUPPORT,

    /**
     * Can view information but cannot make changes.
     */
    SUPPORT,

    /**
     * Can manage users and organizations where it has access.
     */
    ORGANIZATION_ADMIN,

    /**
     * Can manage users and projects where it has access
     */
    ORGANIZATION_SUPPORT,
}
