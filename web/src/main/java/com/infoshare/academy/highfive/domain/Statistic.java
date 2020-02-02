package com.infoshare.academy.highfive.domain;

import javax.persistence.*;

@NamedQueries({
  @NamedQuery(name = "Statistic.findStatisticByMonth", query = "SELECT statistic " +
    "FROM Statistic statistic " +
    "WHERE statistic.monthNumber = :monthNumber"),
  @NamedQuery(name = "Statistic.findStatisticByVacationCount", query = "SELECT statistic " +
    "FROM Statistic statistic ")
})

@Entity
@Table(name = "statistic")
public class Statistic {

  @Id
  @Column(name = "month_number")
  private int monthNumber;

  @Column(name = "month_name")
  private String monthName;

  @Column(name = "vacation_days_count")
  private long vacationDaysCount;

  public int getMonthNumber() {
    return monthNumber;
  }

  public void setMonthNumber(int month) {
    this.monthNumber = month;
  }

  public String getMonthName() {
    return monthName;
  }

  public void setMonthName(String monthName) {
    this.monthName = monthName;
  }

  public long getVacationDaysCount() {
    return vacationDaysCount;
  }

  public void setVacationDaysCount(long vacationDaysCount) {
    this.vacationDaysCount = vacationDaysCount;
  }
}
