package com.kevinbedoya.accentra.domain.model;

import com.kevinbedoya.accentra.domain.model.valueobject.OrganizationId;
import com.kevinbedoya.accentra.domain.model.valueobject.SystemUserId;

public class Organization extends Auditable {
    private final OrganizationId id;
    private String name;

    public Organization(SystemUserId creator, OrganizationId id, String name) {
        super(creator);
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Organization name cannot be null or empty.");
        }
        this.id = id;
        this.name = name;
    }

    /**
     * Change the organization name updating auditing fields.
     *
     * @param newName New organization name.
     * @param editor User that executes the update.
     */
    public void rename(String newName, SystemUserId editor) {
        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException("Organization name cannot be null or empty.");
        }
        this.name = newName;

        super.update(editor);
    }

    public OrganizationId getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
