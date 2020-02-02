package com.infoshare.academy.highfive.dto.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.infoshare.academy.highfive.domain.VacationStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class VacationView {

    private Long id;

    @JsonProperty("employee_id")
    private Long employeeId;

    @JsonProperty("first_name")
    private String firstName;

    private String surname;

    private String position;

    private String email;

    @JsonProperty("vacation_from")
    private LocalDate vacationFrom;

    @JsonProperty("vacation_to")
    private LocalDate vacationTo;

    @JsonProperty("vacation_request_dateTime")
    private LocalDateTime dateOfRequest;

    @JsonProperty("vacation_type")
    private String vacationType;

    @JsonProperty("vacation_status")
    private VacationStatus vacationStatus;

  public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public LocalDateTime getDateOfRequest() {
        return dateOfRequest;
    }

    public void setDateOfRequest(LocalDateTime dateOfRequest) {
        this.dateOfRequest = dateOfRequest;
    }

  public String getVacationType() {
    return vacationType;
  }

  public void setVacationType(String vacationType) {
    this.vacationType = vacationType;
  }

    public VacationStatus getVacationStatus() {
        return vacationStatus;
    }

    public void setVacationStatus(VacationStatus vacationStatus) {
        this.vacationStatus = vacationStatus;
    }

}
