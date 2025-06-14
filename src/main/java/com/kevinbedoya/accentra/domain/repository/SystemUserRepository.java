package com.kevinbedoya.accentra.domain.repository;

import com.kevinbedoya.accentra.domain.model.SystemUser;
import com.kevinbedoya.accentra.domain.model.valueobject.SystemUserId;

import java.util.Optional;

public interface SystemUserRepository {
    void save(SystemUser systemUser);
    Optional<SystemUser> findById(SystemUserId id);
}
