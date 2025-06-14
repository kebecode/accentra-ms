package com.kevinbedoya.accentra.application.dto;

/**
 * Represents the data of an organization sent back to the client.
 * This record is used as a data contract for the application's output boundary.
 *
 * @param id The unique identifier of the organization.
 * @param name The name of the organization.
 */
public record OrganizationResponse(String id, String name) {
}
