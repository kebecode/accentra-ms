package com.kevinbedoya.accentra.application.usecase;

import com.kevinbedoya.accentra.application.dto.CreateOrganizationRequest;
import com.kevinbedoya.accentra.application.exception.PermissionDeniedException;
import com.kevinbedoya.accentra.domain.exception.ResourceNotFoundException;
import com.kevinbedoya.accentra.domain.model.Organization;
import com.kevinbedoya.accentra.domain.model.SystemUser;
import com.kevinbedoya.accentra.domain.model.valueobject.OrganizationId;
import com.kevinbedoya.accentra.domain.model.valueobject.SystemUserId;
import com.kevinbedoya.accentra.domain.repository.OrganizationRepository;
import com.kevinbedoya.accentra.domain.repository.SystemUserRepository;
import org.springframework.stereotype.Service;

/**
 * This use case handles the business logic for creating a new organization.
 * It orchestrates the domain models and repositories to fulfill the request.
 * It is part of the application layer and is independent of web or persistence concerns.
 */
@Service
public class CreateOrganizationUseCase {

    private final OrganizationRepository organizationRepository;
    private final SystemUserRepository systemUserRepository;

    public CreateOrganizationUseCase(OrganizationRepository organizationRepository, SystemUserRepository systemUserRepository) {
        this.organizationRepository = organizationRepository;
        this.systemUserRepository = systemUserRepository;
    }

    public Organization execute(CreateOrganizationRequest request, SystemUserId systemUserId) {
        SystemUser systemUser = systemUserRepository.findById(systemUserId)
                .orElseThrow(() -> new ResourceNotFoundException("System user not found"));

        if (!systemUser.canCreateOrganizations()) {
            throw new PermissionDeniedException("You do not have permission to perform this action");
        }
        Organization newOrganization = new Organization(
                systemUser.getId(),
                OrganizationId.create(),
                request.name()
        );
        organizationRepository.save(newOrganization);

        return newOrganization;
    }
}
