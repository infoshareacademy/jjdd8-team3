package com.infoshare.academy.highfive.domain;

import javax.persistence.*;
import java.time.LocalDate;

@NamedQueries({
  @NamedQuery(name = "Vacation.findVacationByStatus", query = "SELECT vacation " +
    "FROM Vacation vacation " +
    "JOIN FETCH Employee employee ON vacation.employee = employee " +
    "WHERE vacation.vacationStatus = :status"),
  @NamedQuery(name = "Vacation.findVacationById", query = "SELECT vacation " +
    "FROM Vacation vacation " +
    "WHERE vacation.id = :vacationId"),
  @NamedQuery(name = "Vacation.findAbsentToday", query = "SELECT vacation " +
    "FROM Vacation vacation " +
    "WHERE vacation.vacationStatus = :status " +
    "AND (vacation.vacationFrom <= :today " +
    "AND vacation.vacationTo >= :today) " +
    ""),
  @NamedQuery(name = "Vacation.findAbsentByMonth", query = "SELECT vacation " +
    "FROM Vacation vacation " +
    "WHERE vacation.vacationStatus = :status " +
    "AND (vacation.vacationFrom BETWEEN :firstDayOfMonth AND :lastDayOfMonth " +
    "OR vacation.vacationTo BETWEEN :firstDayOfMonth AND :lastDayOfMonth)"),
})

@Entity
@Table(name = "vacation")
public class Vacation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @JoinColumn(name = "employee_id", nullable = false)
  @ManyToOne(fetch = FetchType.EAGER)
  private Employee employee;

  @Column(name = "from_date", nullable = false)
  private LocalDate vacationFrom;

  @Column(name = "to_date", nullable = false)
  private LocalDate vacationTo;

  @Enumerated(EnumType.STRING)
  @Column(name = "vacation_type")
  private VacationType vacationType;

  @Enumerated(EnumType.STRING)
  @Column(name = "vacation_status")
  private VacationStatus vacationStatus;

  public Long getId() {
    return id;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
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
