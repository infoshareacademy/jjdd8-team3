package com.infoshare.academy.highfive.dao;

import com.infoshare.academy.highfive.domain.Employee;
import com.infoshare.academy.highfive.domain.Entitlement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Stateless
public class EntitlementDao {

  @PersistenceContext
  EntityManager entityManager;

  public void updateEntitlement(Entitlement entitlement) {
    entityManager.merge(entitlement);

  }

  @Transactional
  public Entitlement getEntitlementByEmployeeId(Employee employee) {
    return (Entitlement) entityManager.createNamedQuery("Entitlement.findEntitlementByEmployeeId")
      .setParameter("employeeId", employee)
      .getSingleResult();

  }

  @Transactional
  public List<Entitlement> getVacationTakenByEmployee() {
    return entityManager.createNamedQuery("Entitlement.findEmployeeVacationTaken")
      .setMaxResults(5)
      .getResultList();

  }

  @Transactional
  public List<Entitlement> getVacationTakenByTeam() {
    return entityManager.createNamedQuery("Entitlement.findTeamVacationTaken")
      .setMaxResults(5)
      .getResultList();
  }

}
