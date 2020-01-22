package com.infoshare.academy.highfive.dao;

import com.infoshare.academy.highfive.domain.Employee;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EmployeeDao {

  @PersistenceContext
  EntityManager em;

  public void addEmployee(Employee employee) { em.persist(employee); }

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