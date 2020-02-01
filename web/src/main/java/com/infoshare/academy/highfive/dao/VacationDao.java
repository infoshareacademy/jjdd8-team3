package com.infoshare.academy.highfive.dao;

import com.infoshare.academy.highfive.domain.Team;
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

  public List<Vacation> getVacationList(VacationStatus vacationStatus) {

    return entityManager.createNamedQuery("Vacation.findVacationByStatus")
      .setParameter("status", vacationStatus)
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

  public List<Vacation> getAmountOfAbsentThisMonth() {

    LocalDate currentTime = LocalDate.now();

    return entityManager
      .createNamedQuery("Vacation.findAbsentByMonth")
      .setParameter("status", VacationStatus.APPROVED)
      .setParameter("firstDayOfMonth", currentTime.withDayOfMonth(1))
      .setParameter("lastDayOfMonth", currentTime.withDayOfMonth(currentTime.lengthOfMonth()))
      .getResultList();

  }

  public List<Vacation> getAmountOfAbsentNextMonth() {

    LocalDate currentTime = LocalDate.now().plusMonths(1);

    return entityManager
      .createNamedQuery("Vacation.findAbsentByMonth")
      .setParameter("firstDayOfMonth", currentTime.withDayOfMonth(1))
      .setParameter("lastDayOfMonth", currentTime.withDayOfMonth(currentTime.lengthOfMonth()))
      .setParameter("status", VacationStatus.APPROVED)
      .getResultList();

  }

  public List<Vacation> getVacationByTeamInDatesRange(Team team, LocalDate startDate, LocalDate endDate) {
    return entityManager
      .createNamedQuery("Vacation.getByTeamInDateRange")
      .setParameter("team", team)
      .setParameter("startDate", startDate)
      .setParameter("endDate", endDate)
      .getResultList();
  }

  public List<Vacation> getAllVacation(LocalDate startDate, LocalDate endDate) {
    return entityManager
      .createNamedQuery("Vacation.getAllVacation")
      .setParameter("startDate", startDate)
      .setParameter("endDate", endDate)
      .getResultList();
  }

}

