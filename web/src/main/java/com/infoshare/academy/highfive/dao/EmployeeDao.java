package com.infoshare.academy.highfive.dao;

import com.infoshare.academy.highfive.domain.Employee;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EmployeeDao {

  @PersistenceContext
  EntityManager entityManager;

  public void addEmployee(Employee employee) { entityManager.persist(employee); }

  public void editEmployee(Employee employee) {
  }

  public Employee deleteEmployee(Long id) {
    Employee employeeToRemove = getEmployeeById(id);
    entityManager.remove(employeeToRemove);
    return employeeToRemove;
  }

  public Employee getEmployeeById(Long id) {
    return entityManager.find(Employee.class, id);
  }

  public void saveEmployee(Employee employee) {
    entityManager.persist(employee);
  }

  public List<Employee> findAll(){
    return this.entityManager.createNamedQuery("Employee.findAll")
            .getResultList();
  }

}