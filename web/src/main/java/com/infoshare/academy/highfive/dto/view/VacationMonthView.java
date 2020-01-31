package com.infoshare.academy.highfive.dto.view;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VacationMonthView {

  @JsonProperty("month_number")
  private int monthNumber;

  @JsonProperty("month_name")
  private String monthName;

  @JsonProperty("vacation_days_count")
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
