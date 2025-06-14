package com.kevinbedoya.accentra.domain.model;

import com.kevinbedoya.accentra.domain.model.valueobject.SystemUserId;

import java.time.Instant;

public class Auditable {
    private final SystemUserId createdBy;
    private final Instant createdAt;
    private SystemUserId updatedBy;
    private Instant updatedAt;

    protected Auditable(SystemUserId createdBy) {
        this.createdAt = Instant.now();
        this.createdBy = createdBy;
    }

    protected void update(SystemUserId updatedBy) {
        if (updatedBy == null) {
            throw new IllegalArgumentException("Updated by cannot be null.");
        }
        this.updatedAt = Instant.now();
        this.updatedBy = updatedBy;
    }

    public SystemUserId getCreatedBy() {
        return createdBy;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public SystemUserId getUpdatedBy() {
        return updatedBy;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
