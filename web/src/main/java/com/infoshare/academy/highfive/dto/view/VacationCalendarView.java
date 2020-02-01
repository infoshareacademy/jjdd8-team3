package com.infoshare.academy.highfive.dto.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.infoshare.academy.highfive.domain.VacationStatus;
import com.infoshare.academy.highfive.domain.VacationType;

import java.time.LocalDate;

public class VacationCalendarView {

  @JsonProperty("employee_id")
  private Long employeeId;

  @JsonProperty("first_name")
  private String firstName;

  private String surname;

  @JsonProperty("vacation_from")
  private LocalDate vacationFrom;

  @JsonProperty("vacation_to")
  private LocalDate vacationTo;

  @JsonProperty("vacation_type")
  private VacationType vacationType;

  @JsonProperty("vacation_status")
  private VacationStatus vacationStatus;

  @JsonProperty("yearFrom")
  private int yearFrom;

  @JsonProperty("monthFrom")
  private int monthFrom;

  @JsonProperty("dayFrom")
  private int dayFrom;

  @JsonProperty("yearTo")
  private int yearTo;

  @JsonProperty("monthTo")
  private int monthTo;

  @JsonProperty("dayTo")
  private int dayTo;

  public int getYearFrom() {
    return yearFrom;
  }

  public void setYearFrom(int yearFrom) {
    this.yearFrom = yearFrom;
  }

  public int getMonthFrom() {
    return monthFrom;
  }

  public void setMonthFrom(int monthFrom) {
    this.monthFrom = monthFrom;
  }

  public int getDayFrom() {
    return dayFrom;
  }

  public void setDayFrom(int dayFrom) {
    this.dayFrom = dayFrom;
  }

  public int getYearTo() {
    return yearTo;
  }

  public void setYearTo(int yearTo) {
    this.yearTo = yearTo;
  }

  public int getMonthTo() {
    return monthTo;
  }

  public void setMonthTo(int monthTo) {
    this.monthTo = monthTo;
  }

  public int getDayTo() {
    return dayTo;
  }

  public void setDayTo(int dayTo) {
    this.dayTo = dayTo;
  }

  public Long getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public LocalDate getVacationFrom() {
    return vacationFrom;
  }

  public void setVacationFrom(LocalDate vacationFrom) {
    this.vacationFrom = vacationFrom;
  }

  public LocalDate getVacationTo() {
    return vacationTo;
  }

  public void setVacationTo(LocalDate vacationTo) {
    this.vacationTo = vacationTo;
  }

  public VacationType getVacationType() {
    return vacationType;
  }

  public void setVacationType(VacationType vacationType) {
    this.vacationType = vacationType;
  }

  public VacationStatus getVacationStatus() {
    return vacationStatus;
  }

  public void setVacationStatus(VacationStatus vacationStatus) {
    this.vacationStatus = vacationStatus;
  }
}
