package com.kevinbedoya.accentra.domain.model;

import com.kevinbedoya.accentra.domain.model.enums.SystemUserRole;
import com.kevinbedoya.accentra.domain.model.valueobject.SystemUserId;

public class SystemUser extends Auditable {
    private final SystemUserId id;
    private final SystemUserRole role;
    private boolean status;

    public SystemUser(SystemUserId creatorId, SystemUserRole role, SystemUserId id, boolean status) {
        super(creatorId);
        this.id = id;
        this.role = role;
        this.status = status;
    }

    /**
     * Business logic method that checks if this user is in a valid state
     * and has the correct role to create organizations.
     *
     * @return true if the user can create organizations, false otherwise.
     */
    public boolean canCreateOrganizations() {
        if (!this.isActive()) {
            return false;
        }

        return switch (this.role) {
            case SUPER_ADMIN, ORGANIZATION_ADMIN -> true;
            case ADMIN_SUPPORT, SUPPORT, ORGANIZATION_SUPPORT -> false;
        };
    }

    public SystemUserId getId() {
        return id;
    }

    public SystemUserRole getRole() {
        return role;
    }

    public boolean isActive() {
        return status;
    }
}
