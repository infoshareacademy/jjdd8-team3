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

    public List searchHolidayByName() {
        return this.em
            .createNamedQuery("Holiday.searchByName")
            .getResultList();
    }

    public List searchHolidayByDate() {
      return this.em
            .createNamedQuery("Holiday.searchByDate")
            .getResultList();
            }

}
