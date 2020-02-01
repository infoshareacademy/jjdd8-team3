package com.infoshare.academy.highfive.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {

    @JsonProperty("Admin")
    ADMIN("Admin", true),

    MANAGER("Manager", true),

    EMPLOYEE("Employee", true),

    AAA("AAA", true);

    @JsonValue
    private final String role;
    private final boolean free;

    Role(String role, boolean free) {
        this.role = role;
        this.free = free;
    }

    public String getRole() { return role; }

    public boolean isFree() { return free; }
}
