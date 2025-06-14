package com.kevinbedoya.accentra.domain.model.valueobject;

public record Email(String value) {
    public Email {
        if (value == null || !value.contains("@")) {
            throw new IllegalArgumentException("Invalid email address format");
        }
    }
}
