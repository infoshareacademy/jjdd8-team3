package com.infoshare.academy.highfive.dto.view;

public class VacationMonthView {

  private int monthNumber;

  private String monthName;

  private long vacationDaysCount;

  public int getMonthNumber() {
    return monthNumber;
  }

  public void setMonthNumber(int monthNumber) {
    this.monthNumber = monthNumber;
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
