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
      .setParameter("status", VacationStatus.APPROVED)
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
    LocalDate currentTime = LocalDate.now();

    return entityManager
      .createNamedQuery("Vacation.findAbsentByMonth")
      .setParameter("status", VacationStatus.APPROVED)
      .setParameter("firstDayOfMonth", currentTime.withDayOfMonth(1))
      .setParameter("lastDayOfMonth", currentTime.withDayOfMonth(currentTime.lengthOfMonth()))
      .getResultList().size();
  }

  public Integer getAmountOfAbsentNextMonth() {
    LocalDate currentTime = LocalDate.now().plusMonths(1);

    return entityManager
      .createNamedQuery("Vacation.findAbsentByMonth")
      .setParameter("firstDayOfMonth", currentTime.withDayOfMonth(1))
      .setParameter("lastDayOfMonth", currentTime.withDayOfMonth(currentTime.lengthOfMonth()))
      .setParameter("status", VacationStatus.APPROVED)
      .getResultList().size();
  }

  public Integer getPendingRequestsListSize() {
    return entityManager.createNamedQuery("Vacation.findPendingRequests")
      .setParameter("status", VacationStatus.APPLIED)
      .getResultList().size();

  }

}

