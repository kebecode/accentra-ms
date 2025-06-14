package com.kevinbedoya.accentra.domain.model;

import com.kevinbedoya.accentra.domain.model.valueobject.Email;
import com.kevinbedoya.accentra.domain.model.valueobject.SystemUserId;
import com.kevinbedoya.accentra.domain.model.valueobject.UserId;

public class User extends Auditable {
    private final UserId id;
    private final Email email;
    private String name;

    public User(SystemUserId creatorId, UserId id, Email email, String name) {
        super(creatorId);
        this.id = id;
        this.email = email;
        this.name = name;
    }
}
