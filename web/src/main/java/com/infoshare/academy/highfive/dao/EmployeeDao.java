package com.infoshare.academy.highfive.dao;

import com.infoshare.academy.highfive.domain.Employee;
import com.infoshare.academy.highfive.domain.Vacation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EmployeeDao {

  public void addEmployee(Employee employee) {
  }

  public void editEmployee(Employee employee) {
  }

  public void deleteEmployee(Employee employee) {
  }

  @PersistenceContext
  EntityManager entityManager;

  public Employee getEmployeeById(Long id) {
    return entityManager.find(Employee.class, id);
  }

  public void saveEmployee(Employee employee) {
    entityManager.persist(employee);
  }




}
