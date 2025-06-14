package com.kevinbedoya.accentra.domain.model.valueobject;

import java.util.UUID;

public record SystemUserId(UUID value) {
    /**
     * Factory method to create an UserId random.
     */
    public static SystemUserId create() {
        return new SystemUserId(UUID.randomUUID());
    }

    /**
     * Factory method to construct an UserId from an existing String.
     */
    public static SystemUserId fromString(String uuid) {
        try {
            return new SystemUserId(UUID.fromString(uuid));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid UUID format", e);
        }
    }
}
