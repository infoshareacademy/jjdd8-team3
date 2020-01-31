package com.infoshare.academy.highfive.dto.view;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class VacationStatisticView {

  private Integer currentMonthTotal;

  private Integer nextMonthTotal;

  private Integer absentToday;

  private Integer pendingRequests;

  public Integer getCurrentMonthTotal() {
    return currentMonthTotal;
  }

  public void setCurrentMonthTotal(Integer currentMonthTotal) {
    this.currentMonthTotal = currentMonthTotal;
  }

  public Integer getNextMonthTotal() {
    return nextMonthTotal;
  }

  public void setNextMonthTotal(Integer nextMonthTotal) {
    this.nextMonthTotal = nextMonthTotal;
  }

  public Integer getAbsentToday() {
    return absentToday;
  }

  public void setAbsentToday(Integer absentToday) {
    this.absentToday = absentToday;
  }

  public Integer getPendingRequests() {
    return pendingRequests;
  }

  public void setPendingRequests(Integer pendingRequests) {
    this.pendingRequests = pendingRequests;
  }
}
