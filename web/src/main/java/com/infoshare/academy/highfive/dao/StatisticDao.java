package com.infoshare.academy.highfive.dao;

import com.infoshare.academy.highfive.domain.Statistic;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class StatisticDao {

  @PersistenceContext
  EntityManager entityManager;

  public Statistic getStatisticByMonth(int monthNumber) {

    return (Statistic) entityManager.createNamedQuery("Statistic.findStatisticByMonth")
      .setParameter("monthNumber", monthNumber)
      .getSingleResult();

  }

  public List<Statistic> getStatisticListSortedByVacationDaysCount() {

    return entityManager.createNamedQuery("Statistic.findStatisticByVacationCount")
      .getResultList();

  }

  public void saveStatistic(Statistic statistic) {
    entityManager.merge(statistic);
  }

}
