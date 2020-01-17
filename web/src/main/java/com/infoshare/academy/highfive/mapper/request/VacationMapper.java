package com.infoshare.academy.highfive.mapper.request;

import com.infoshare.academy.highfive.domain.Employee;
import com.infoshare.academy.highfive.domain.Vacation;
import com.infoshare.academy.highfive.dto.EmployeeDTO;
import com.infoshare.academy.highfive.request.VacationRequest;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class VacationMapper {

  @Inject
  EmployeeMapper employeeMapper;

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
