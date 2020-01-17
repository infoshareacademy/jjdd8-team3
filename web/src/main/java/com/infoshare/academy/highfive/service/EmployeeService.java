package com.infoshare.academy.highfive.service;

import com.infoshare.academy.highfive.dao.EmployeeDao;
import com.infoshare.academy.highfive.domain.Employee;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class EmployeeService {

  @Inject
  private EmployeeMapper employeeMapper;
  @Inject
  private EmployeeDao employeeDao;

  public void addNewEmployee(EmployeeRequest request) {
    employeeDao.addEmployee(employeeMapper.mapRequestToEntity(request));
  }

  public void editEmployee(EmployeeRequest request) {
    employeeDao.editEmployee(employeeMapper.mapRequestToEntity(request));
  }

  public void deleteEmployee(EmployeeRequest request) {
    employeeDao.deleteEmployee(employeeMapper.mapRequestToEntity(request));
  }

  public void updateVacationEntitlementOnYearStart() {

  }

  public void updateVacationEntitlementOnYearEnd() {
  }

  public Employee getById(Long id) {
    return this.employeeDao.getEmployeeById(id);
  }
