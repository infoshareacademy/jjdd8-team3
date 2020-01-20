package com.infoshare.academy.highfive.dao;

import com.infoshare.academy.highfive.domain.Holiday;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Stateless
public class HolidayDao {

    @PersistenceContext
    EntityManager em;

    public void saveHoliday(Holiday holiday) {
        em.persist(holiday);
    }

    public List listAllHoliday() {
        return this.em
                .createNamedQuery("Holiday.findAll")
                .getResultList();
    }

    public Holiday searchHolidayByName(String searchName) {
        return (Holiday) em
                    .createNamedQuery("Holiday.searchByName")
                    .setParameter("searchName", searchName)
                    .getSingleResult();
    }

    public Holiday searchHolidayByDate(String searchDate) {
      return (Holiday) em
              .createNamedQuery("Holiday.searchByDate")
              .setParameter("searchDate", searchDate)
              .getSingleResult();
            }

}
