package com.infoshare.academy.highfive.dto;

import com.infoshare.academy.highfive.domain.Employee;
import com.infoshare.academy.highfive.domain.VacationStatus;
import com.infoshare.academy.highfive.domain.VacationType;

import java.time.LocalDate;

public class VacationFullDTO {

  private Employee employee;
  private LocalDate vacationFrom;
  private LocalDate vacationTo;
  private VacationType vacationType;
  private VacationStatus vacationStatus;

  public VacationFullDTO(Employee employee, LocalDate vacationFrom, LocalDate vacationTo, VacationType vacationType, VacationStatus vacationStatus) {
    this.employee = employee;
    this.vacationFrom = vacationFrom;
    this.vacationTo = vacationTo;
    this.vacationType = vacationType;
    this.vacationStatus = vacationStatus;
  }

  public Employee getEmployeeId() { return employee; }

  public LocalDate getVacationFrom() {
    return vacationFrom;
  }

  public LocalDate getVacationTo() {
    return vacationTo;
  }

  public VacationType getVacationType() {
    return vacationType;
  }

  public VacationStatus getVacationStatus() {
    return vacationStatus;
  }
}
