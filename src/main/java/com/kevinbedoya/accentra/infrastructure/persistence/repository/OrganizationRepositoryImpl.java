package com.kevinbedoya.accentra.infrastructure.persistence.repository;

import com.kevinbedoya.accentra.domain.model.Organization;
import com.kevinbedoya.accentra.domain.model.valueobject.OrganizationId;
import com.kevinbedoya.accentra.domain.model.valueobject.SystemUserId;
import com.kevinbedoya.accentra.domain.repository.OrganizationRepository;
import com.kevinbedoya.accentra.infrastructure.persistence.dbo.OrganizationDbo;
import com.kevinbedoya.accentra.infrastructure.persistence.jpa.OrganizationJpaRepository;
import com.kevinbedoya.accentra.infrastructure.persistence.mapper.OrganizationMapper;

import java.util.Optional;

public class OrganizationRepositoryImpl implements OrganizationRepository {
    private final OrganizationJpaRepository jpaRepository;
    private final OrganizationMapper mapper;

    public OrganizationRepositoryImpl(OrganizationJpaRepository jpaRepository, OrganizationMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public void save(Organization organization) {
        OrganizationDbo dbo = mapper.toDbo(organization);
        jpaRepository.save(dbo);
    }

    @Override
    public Optional<Organization> findById(OrganizationId id) {
        return jpaRepository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public Optional<Organization> findByCreator(SystemUserId systemUserId) {
        return jpaRepository.findByCreatedBy(systemUserId.value()).map(mapper::toDomain);
    }
}
