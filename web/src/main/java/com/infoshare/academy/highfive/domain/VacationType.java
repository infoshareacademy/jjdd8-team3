package com.infoshare.academy.highfive.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public enum VacationType {

  @JsonProperty("Vacation")
  VACATION("Vacation"),
  PARENTAL("Parental"),
  ON_DEMAND("On demand");

  @JsonValue
  private final String vacationType;

  VacationType(String vacationType) {
    this.vacationType = vacationType;
  }

  public String getVacationType() {
    return vacationType;
  }
}
