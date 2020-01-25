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

    public void save(Team team){
        entityManager.persist(team);
    }

    public List<Team> listAllTeam(){
        return this.entityManager
                .createNamedQuery("Team.findAll")
                .getResultList();
    }

    public Optional<Team> getById(Long id) {
        return Optional.ofNullable(entityManager.find(Team.class, id));
    }

    public void update(Team team){ entityManager.merge(team); }

    public void edit(){}

    public Team delete (Long id){
        Team removedTeam = getById(id).orElseThrow();
        if (removedTeam != null){entityManager.remove(removedTeam);}
        return removedTeam;
    }

}