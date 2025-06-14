package com.kevinbedoya.accentra.infrastructure.persistence.jpa;

import com.kevinbedoya.accentra.infrastructure.persistence.dbo.OrganizationDbo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Spring Data JPA repository interface for the OrganizationDbo.
 * This provides standard CRUD operations on the 'organizations' table at a low level.
 */
public interface OrganizationJpaRepository extends JpaRepository<OrganizationDbo, UUID> {
    Optional<OrganizationDbo> findByCreatedBy(UUID createdBy);
}