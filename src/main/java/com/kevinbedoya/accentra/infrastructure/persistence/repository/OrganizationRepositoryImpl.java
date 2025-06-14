package com.kevinbedoya.accentra.infrastructure.persistence.repository;

import com.kevinbedoya.accentra.domain.model.Organization;
import com.kevinbedoya.accentra.domain.model.valueobject.OrganizationId;
import com.kevinbedoya.accentra.domain.model.valueobject.SystemUserId;
import com.kevinbedoya.accentra.domain.repository.OrganizationRepository;
import com.kevinbedoya.accentra.infrastructure.persistence.jpa.OrganizationJpaRepository;

import java.util.Optional;

public class OrganizationRepositoryImpl implements OrganizationRepository {
    private OrganizationJpaRepository jpaRepository;

    public OrganizationRepositoryImpl(OrganizationJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void save(Organization organization) {

    }

    @Override
    public Optional<Organization> findById(OrganizationId id) {
        return Optional.empty();
    }

    @Override
    public Optional<Organization> findByCreator(SystemUserId systemUserId) {
        return Optional.empty();
    }
}
