package com.infoshare.academy.highfive.dao;

import com.infoshare.academy.highfive.domain.Holiday;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Stateless
public class HolidayDao {

    @PersistenceContext
    EntityManager em;

    public void saveHoliday(Holiday holiday) {
        em.persist(holiday);
    }

    public List<Holiday> listAllHoliday() {
        return this.em
                .createNamedQuery("Holiday.findAll")
                .getResultList();
    }

    public List<LocalDate> listAllHolidayDates() {
      return this.em
        .createNamedQuery("Holiday.findAllDates")
        .getResultList();
    }

    public Optional<Holiday> getById(Long id) {
        return Optional.ofNullable(em.find(Holiday.class, id));
    }

    public void update(Holiday holiday) {
        em.merge(holiday);
    }

    public Holiday deleteById(Long id) {
        Holiday holidayToRemove = getById(id).orElseThrow();
        if (holidayToRemove != null) {
            em.remove(holidayToRemove);
        }
        return holidayToRemove;
    }


    public List searchHolidayByName() {
        return this.em
            .createNamedQuery("Holiday.searchByName")
            .getResultList();
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
