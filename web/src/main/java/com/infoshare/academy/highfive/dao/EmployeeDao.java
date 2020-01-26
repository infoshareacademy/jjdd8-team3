package com.infoshare.academy.highfive.dao;

import com.infoshare.academy.highfive.domain.Employee;
import com.infoshare.academy.highfive.dto.view.EmployeeView;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class EmployeeDao {

    @PersistenceContext
    EntityManager em;

    public void save(Employee employee) {
        em.persist(employee);
    }

    public Optional<Employee> getById(Long id) {
        return Optional.ofNullable(em.find(Employee.class, id));
    }

    public Employee findById(Long id) {
        return em.find(Employee.class, id);
    }


    public List<Employee> listAllEmployees() {
        return this.em.createNamedQuery("Employee.findAll").getResultList();
    }

    public void update(Employee employee){ em.merge(employee); }

  public Employee delete(Long id) {
    Employee removedEmployee = getById(id).orElseThrow();
    if (removedEmployee != null) {
      em.remove(removedEmployee);
    }
    return removedEmployee;
  }

}