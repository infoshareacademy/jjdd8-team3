package com.infoshare.academy.highfive.dao;

import com.infoshare.academy.highfive.domain.Employee;
import com.infoshare.academy.highfive.domain.Entitlement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class EntitlementDao {

    @PersistenceContext
    EntityManager entityManager;

    public void updateEntitlement(Entitlement entitlement) {

        entityManager.merge(entitlement);

    }

    public Entitlement getEntitlementByEmployeeId(Employee employee) {

        return (Entitlement) entityManager.createNamedQuery("Entitlement.findEntitlementByEmployeeId")
                .setParameter("employeeId", employee)
                .getSingleResult();

    }

    public void save(Entitlement entitlement) {

        entityManager.persist(entitlement);
    }
}
