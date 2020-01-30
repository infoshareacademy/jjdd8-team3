package com.infoshare.academy.highfive.mapper.entity;

import com.infoshare.academy.highfive.domain.Statistic;
import com.infoshare.academy.highfive.dto.view.VacationMonthView;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class VacationEmployeeMapper {

  public VacationMonthView mapEntityToView(Statistic statistic) {
    VacationMonthView vacationMonthView = new VacationMonthView();
    vacationMonthView.setMonthName(statistic.getMonthName());
    vacationMonthView.setMonthNumber(statistic.getMonthNumber());
    vacationMonthView.setVacationDaysCount(statistic.getVacationDaysCount());
    return vacationMonthView;
  }
}
