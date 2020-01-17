package com.infoshare.academy.highfive.service;

import com.infoshare.academy.highfive.dao.EmployeeDao;
import com.infoshare.academy.highfive.domain.Employee;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class EmployeeService {

  @Inject
  EmployeeDao employeeDao;

  public void updateVacationEntitlementOnYearStart() {

  }

  public void updateVacationEntitlementOnYearEnd() {
  }

  public Employee getById(Long id) {
    return this.employeeDao.getEmployeeById(id);
  }
}
