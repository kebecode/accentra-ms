package com.kevinbedoya.accentra.domain.model.valueobject;

import java.util.UUID;

public record UserId(UUID value) {

    /**
     * Factory method to create an UserId random.
     */
    public static UserId create() {
        return new UserId(UUID.randomUUID());
    }

    /**
     * Factory method to construct an UserId from an existing String.
     */
    public static UserId fromString(String uuid) {
        try {
            return new UserId(UUID.fromString(uuid));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid UUID format", e);
        }
    }
}
