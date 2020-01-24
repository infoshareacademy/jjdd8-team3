package com.infoshare.academy.highfive.dao;

import com.infoshare.academy.highfive.domain.Vacation;
import com.infoshare.academy.highfive.domain.VacationStatus;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class VacationDao {

  @PersistenceContext
  EntityManager entityManager;

  public void addVacation(Vacation vacation) {

    this.entityManager.persist(vacation);

  }

  public List<Vacation> getPendingRequestsList() {

    return entityManager.createNamedQuery("Vacation.findPendingRequests")
      .setParameter("status", VacationStatus.APPLIED)
      .getResultList();

  }

  public int getAmountOfAbsentToday() {
    return entityManager.createNamedQuery("Vacation.findAbsentToday")
      .setParameter("today", LocalDate.now())
      .getResultList().size();

  }

  public Vacation getVacationById(Long vacationId) {

    return (Vacation) entityManager
      .createNamedQuery("Vacation.findVacationById")
      .setParameter("vacationId", vacationId)
      .getSingleResult();
  }

  public void updateVacationStatus(Vacation vacation) {

    entityManager.merge(vacation);

  }

  public Integer getAmountOfAbsentThisMonth() {
    return entityManager
      .createNamedQuery("Vacation.findAbsentThisMonth")
      .setParameter("currentMonth", LocalDate.now())
      .getResultList().size();
  }

}

