package com.kevinbedoya.accentra.domain.repository;

import com.kevinbedoya.accentra.domain.model.Organization;
import com.kevinbedoya.accentra.domain.model.valueobject.OrganizationId;
import com.kevinbedoya.accentra.domain.model.valueobject.SystemUserId;
import com.kevinbedoya.accentra.domain.model.valueobject.UserId;

import java.util.Optional;

/**
 * An output port that defines the persistence operations for the Organization entity.
 * This interface is part of the domain layer and dictates the contract that any
 * persistence adapter must implement, without knowing any implementation details.
 */
public interface OrganizationRepository {
    /**
     * Persists a new organization or updates an existing one.
     *
     * @param organization The organization entity to be saved. It must not be null.
     */
    void save(Organization organization);

    /**
     * Finds an organization by its unique identifier.
     *
     * @param id The unique ID of the organization. It must not be null.
     * @return an {@link Optional} containing the organization if found, otherwise empty.
     */
    Optional<Organization> findById(OrganizationId id);
    Optional<Organization> findByCreator(SystemUserId systemUserId);
}
