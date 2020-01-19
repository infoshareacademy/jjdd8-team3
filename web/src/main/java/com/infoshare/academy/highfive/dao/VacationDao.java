package com.infoshare.academy.highfive.dao;

import com.infoshare.academy.highfive.domain.Vacation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class VacationDao {

  @PersistenceContext
  EntityManager entityManager;

  public void addVacation(Vacation vacation) {

    this.entityManager.persist(vacation);

  }

  public List getPendingRequestsList() {

    return entityManager.createNamedQuery("Vacation.findPendingRequests")
      .getResultList();

  }
}
