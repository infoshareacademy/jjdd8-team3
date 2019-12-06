package com.infoshare.academy.highfive;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public enum HolidayType {

    @JsonProperty("National holiday")
    NATIONAL_HOLIDAY("National holiday", true),

    @JsonProperty("Observance")
    OBSERVANCE("Observance", false),

    @JsonProperty("Season")
    SEASON("Season", false);

    @JsonValue
    private final String type;

    private final boolean free;

    HolidayType(String type, boolean free) {
        this.type = type;
        this.free = free;
    }

    public String getType() {
        return type;
    }

    public boolean isFree() {
        return free;
    }

}
