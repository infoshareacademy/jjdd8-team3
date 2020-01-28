package com.infoshare.academy.highfive.dao;

import com.infoshare.academy.highfive.domain.Employee;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class EmployeeDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    public Optional<Employee> getById(Long id) {
        return Optional.ofNullable(entityManager.find(Employee.class, id));
    }

    public Employee findById(Long id) {
        return entityManager.find(Employee.class, id);
    }


    public List<Employee> listAllEmployees() {
        return this.entityManager.createNamedQuery("Employee.findAll").getResultList();
    }

    public void update(Employee employee){ entityManager.merge(employee); }

  public Employee delete(Long id) {
    Employee removedEmployee = getById(id).orElseThrow();
    if (removedEmployee != null) {
      entityManager.remove(removedEmployee);
    }
    return removedEmployee;
  }

}