package com.infoshare.academy.highfive.domain;

import javax.persistence.*;
import java.time.LocalDate;

@NamedQueries({
  @NamedQuery(name = "Entitlement.findEntitlementByEmployeeId", query = "SELECT entitlement " +
    "FROM Entitlement entitlement " +
    "WHERE entitlement.employee = :employeeId"),
  @NamedQuery(name = "Entitlement.findRemainingEntitlement", query = "SELECT (entitlement.previousYearLeft + entitlement.vacationLeft + entitlement.additionalLeft + entitlement.onDemandHolidayLeft) AS entitlementSum, entitlement.employee " +
    "FROM Entitlement entitlement " +
    "ORDER BY entitlementSum")
}
)

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
  private int onDemandHolidayLeft;

  @OneToOne
  @JoinColumn(unique = true, name = "employee_id")
  Employee employee;

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

  public int getOnDemandHolidayLeft() {
    return onDemandHolidayLeft;
  }

  public void setOnDemandHolidayLeft(int onDemandHolidayLeft) {
    this.onDemandHolidayLeft = onDemandHolidayLeft;
  }
}
