package com.infoshare.academy.highfive.dao;

import com.infoshare.academy.highfive.domain.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.registry.infomodel.User;
import java.util.List;
import java.util.Optional;

@Stateless
public class EmployeeDao {

  public void addEmployee(Employee employee) {
  }

  public void editEmployee(Employee employee) {
  }

  public void deleteEmployee(Employee employee) {
  }

  private Logger logger = LoggerFactory.getLogger(getClass().getName());
  @PersistenceContext
  EntityManager entityManager;

  public Employee getEmployeeById(Long id) {
    return entityManager.find(Employee.class, id);
  }

  public void saveEmployee(Employee employee) {
    entityManager.persist(employee);
  }

  public List<Employee> listAllEmployees() {
    return this.entityManager.createNamedQuery("Employee.findAll").getResultList();
  }

  public Optional<Employee> findByEmail(String email) {

    Query query = entityManager.createNamedQuery("Employee.findByEmail");
    query.setParameter("email", email);
    List<Employee> employees = query.getResultList();
    logger.info("Object Employee: {} has been found", email);
    if (employees.isEmpty()) {
      logger.warn("Employee for email {} not found", email);
      return Optional.empty();
    }
    return Optional.of(employees.get(0));
  }

  public void update(Employee employee) {
    entityManager.merge(employee);
  }

}
