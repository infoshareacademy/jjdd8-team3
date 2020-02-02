package com.infoshare.academy.highfive.domain;

import javax.json.bind.annotation.JsonbProperty;

public enum VacationStatus {

  @JsonbProperty("VacationStatus")
  APPLIED("Applied"),
  APPROVED("Approved"),
  DENIED("Denied");

  private final String vacationStatus;

  VacationStatus(String vacationStatus) {
    this.vacationStatus = vacationStatus;
  }

  public String getVacationStatus() {
    return vacationStatus;
  }
}
