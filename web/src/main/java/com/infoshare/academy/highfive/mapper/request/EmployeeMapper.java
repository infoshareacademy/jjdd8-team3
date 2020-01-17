package com.infoshare.academy.highfive.mapper.request;

import com.infoshare.academy.highfive.domain.Employee;
import com.infoshare.academy.highfive.dto.EmployeeDTO;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class EmployeeMapper {

  public EmployeeDTO mapEntityToView(Employee employee) { return new EmployeeDTO(employee.getId(), employee.getFirstName(), employee.getSurname(), employee.getHireDate(), employee.getHolidayEntitlement(), employee.getAdditionalEntitlement() , employee.getTeamId(), employee.getRoleId());}

}
