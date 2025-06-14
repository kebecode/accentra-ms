package com.kevinbedoya.accentra.infrastructure.persistence.mapper;

import com.kevinbedoya.accentra.domain.model.Organization;
import com.kevinbedoya.accentra.infrastructure.persistence.dbo.OrganizationDbo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {
    @Mapping(source = "id.value", target = "id")
    @Mapping(source = "createdBy.value", target = "createdBy")
    @Mapping(source = "updatedBy.value", target = "updatedBy")
    OrganizationDbo toDbo(Organization organization);

    @Mapping(source = "id", target = "id.value")
    @Mapping(source = "createdBy", target = "createdBy.value")
    @Mapping(source = "updatedBy", target = "updatedBy.value")
    Organization toDomain(OrganizationDbo dbo);
}
