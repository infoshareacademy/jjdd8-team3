package com.infoshare.academy.highfive.dto.request;

import com.infoshare.academy.highfive.domain.Employee;
import com.infoshare.academy.highfive.domain.Role;
import com.infoshare.academy.highfive.domain.VacationStatus;
import com.infoshare.academy.highfive.domain.VacationType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class VacationRequest {

  private Long employeeId;

  private Role role;

  private LocalDate dateFrom;

  private LocalDate dateTo;

  private VacationType vacationType;

  private VacationStatus vacationStatus;

  private LocalDateTime dateOfRequest;

  public LocalDateTime getDataOfRequest() {
    return dateOfRequest;
  }

  public void setDateOfRequest(LocalDateTime dateOfRequest) {
    this.dateOfRequest = dateOfRequest;
  }

  public VacationStatus getVacationStatus() {
    return vacationStatus;
  }

  public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

  public void setVacationStatus(VacationStatus vacationStatus) {
    this.vacationStatus = vacationStatus;
  }

  public Long getEmployeeId() {
    return employeeId;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public LocalDate getDateFrom() { return this.dateFrom; }

  public void setDateFrom(LocalDate dateFrom) {
    this.dateFrom = dateFrom;
  }

  public LocalDate getDateTo() {
    return dateTo;
  }

  public void setDateTo(LocalDate dateTo) {
    this.dateTo = dateTo;
  }

  public VacationType getVacationType() {
    return vacationType;
  }

  public void setVacationType(VacationType vacationType) {
    this.vacationType = vacationType;
  }
}
