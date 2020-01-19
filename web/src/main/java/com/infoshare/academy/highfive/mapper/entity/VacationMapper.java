package com.infoshare.academy.highfive.mapper.entity;

import com.infoshare.academy.highfive.domain.Employee;
import com.infoshare.academy.highfive.domain.Vacation;
import com.infoshare.academy.highfive.dto.request.VacationRequest;

import javax.ejb.Stateless;

@Stateless
public class VacationMapper {

  public Vacation mapRequestToEntity(Employee employee, VacationRequest vacationRequest) {

    Vacation vacation = new Vacation();
    vacation.setEmployee(employee);
    vacation.setVacationFrom(vacationRequest.getDateFrom());
    vacation.setVacationTo(vacationRequest.getDateTo());
    vacation.setVacationType(vacationRequest.getVacationType());
    vacation.setVacationStatus(vacationRequest.getVacationStatus());

    return vacation;

  }

}
