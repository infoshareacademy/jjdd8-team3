package com.infoshare.academy.highfive.domain;

import javax.persistence.*;

@NamedQueries({
  @NamedQuery(name = "findAllStatistic", query = "SELECT statistic FROM Statistic statistic")
})

@Entity
@Table(name = "statistic")
public class Statistic {

  @Id
  @Column(name = "month_number")
  private int month;

  @Column(name = "month_name")
  private String monthName;

  @Column(name = "vacation_days_count")
  private long vacationDaysCount;
}
