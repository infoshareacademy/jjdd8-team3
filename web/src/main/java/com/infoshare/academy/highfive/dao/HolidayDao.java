package com.infoshare.academy.highfive.dao;

import com.infoshare.academy.highfive.domain.Holiday;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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


}
