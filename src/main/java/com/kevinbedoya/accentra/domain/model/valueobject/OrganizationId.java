package com.kevinbedoya.accentra.domain.model.valueobject;

import java.util.UUID;

public record OrganizationId(UUID value) {
    /**
     * Factory method to create an UserId random.
     */
    public static OrganizationId create() {
        return new OrganizationId(UUID.randomUUID());
    }

    /**
     * Factory method to construct an UserId from an existing String.
     */
    public static OrganizationId fromString(String uuid) {
        try {
            return new OrganizationId(UUID.fromString(uuid));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid UUID format", e);
        }
    }
}
