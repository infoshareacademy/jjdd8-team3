package com.infoshare.academy.highfive.dao;

import com.infoshare.academy.highfive.domain.Employee;
import com.infoshare.academy.highfive.domain.Entitlement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Stateless
public class EntitlementDao {

  @PersistenceContext
  EntityManager entityManager;

  public void updateEntitlement(Entitlement entitlement) {
    entityManager.merge(entitlement);

  }

  public Entitlement getEntitlementByEmployeeId(Employee employee) {
    return (Entitlement) entityManager.createNamedQuery("Entitlement.findEntitlementByEmployeeId")
      .setParameter("employeeId", employee)
      .getSingleResult();

  }

  public List<Entitlement> getVacationTakenByEmployee() {
    return entityManager.createNamedQuery("Entitlement.findEmployeeVacationTaken")
      .getResultList();

  }

  public List<Entitlement> getVacationTakenByTeam() {
    return entityManager.createNamedQuery("Entitlement.findTeamVacationTaken")
      .getResultList();
  }

}
