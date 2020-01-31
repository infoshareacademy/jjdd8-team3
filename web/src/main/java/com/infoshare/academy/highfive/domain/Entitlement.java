package com.infoshare.academy.highfive.domain;

import javax.persistence.*;
import java.time.LocalDate;

@NamedQueries({
  @NamedQuery(name = "Entitlement.findEntitlementByEmployee", query = "SELECT entitlement " +
    "FROM Entitlement entitlement " +
    "WHERE entitlement.employee = :employee"),
  @NamedQuery(name = "Entitlement.findEmployeeVacationTaken", query = "SELECT entitlement " +
    "FROM Entitlement entitlement " +
    "ORDER BY entitlement.vacationTaken DESC"),
  @NamedQuery(name = "Entitlement.findTeamVacationTaken", query = "SELECT SUM(entitlement.vacationTaken), team.teamName " +
    "FROM Entitlement entitlement " +
    "JOIN FETCH Employee employee ON entitlement.employee = employee " +
    "JOIN FETCH Team team ON employee.team = team " +
    "GROUP BY team.teamName"),

})

@Entity
@Table(name = "entitlement")
public class Entitlement {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private int id;

  @Column(name = "current_year", nullable = false)
  private LocalDate currentYear;

  @Column(name = "previous_year_left", nullable = false)
  private int previousYearLeft;

  @Column(name = "vacation_left", nullable = false)
  private int vacationLeft;

  @Column(name = "additional_left", nullable = false)
  private int additionalLeft;

  @Column(name = "on_demand_holiday_left", nullable = false)
  private int onDemandVacationLeft;

  @Column(name = "days_taken")
  private int vacationTaken;

  @OneToOne
  @JoinColumn(unique = true, name = "employee_id", nullable = false)
  private Employee employee;

  public int getId() {
    return id;
  }

  public LocalDate getCurrentDate() {
    return currentYear;
  }

  public void setCurrentDate(LocalDate currentDate) {
    this.currentYear = currentDate;
  }

  public int getPreviousYearLeft() {
    return previousYearLeft;
  }

  public void setPreviousYearLeft(int previousYearLeft) {
    this.previousYearLeft = previousYearLeft;
  }

  public int getVacationLeft() {
    return vacationLeft;
  }

  public void setVacationLeft(int vacationLeft) {
    this.vacationLeft = vacationLeft;
  }

  public int getAdditionalLeft() {
    return additionalLeft;
  }

  public void setAdditionalLeft(int additionalLeft) {
    this.additionalLeft = additionalLeft;
  }

  public int getOnDemandVacationLeft() {
    return onDemandVacationLeft;
  }

  public void setOnDemandVacationLeft(int onDemandHolidayLeft) {
    this.onDemandVacationLeft = onDemandHolidayLeft;
  }

  public int getVacationTaken() {
    return vacationTaken;
  }

  public void setVacationTaken(int holidayTaken) {
    this.vacationTaken = holidayTaken;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }
}
