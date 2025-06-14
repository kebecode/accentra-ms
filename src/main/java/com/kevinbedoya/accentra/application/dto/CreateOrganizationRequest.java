package com.kevinbedoya.accentra.application.dto;

/**
 * Represents the data required to create a new organization.
 * This record is used as a data contract for the application's input boundary.
 *
 * @param name The desired name for the new organization.
 */
public record CreateOrganizationRequest(String name) {
}
