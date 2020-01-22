package com.infoshare.academy.highfive.dao;

import com.infoshare.academy.highfive.domain.Team;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class TeamDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveTeam(Team team){
        entityManager.persist(team);
    }

    public Optional<Team> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Team.class, id));
    }

    public List<Team> findAll() {
        return entityManager.createNamedQuery("Team.findAll").getResultList();
    }

    public void editTeam(){}

    public void deleteTeam (){}

}