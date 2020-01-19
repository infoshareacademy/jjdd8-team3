package com.infoshare.academy.highfive.service;

import com.infoshare.academy.highfive.dao.TeamDao;
import com.infoshare.academy.highfive.domain.Team;
import com.infoshare.academy.highfive.mapper.entity.TeamMapper;
import com.infoshare.academy.highfive.request.TeamRequest;
import com.sun.xml.bind.v2.TODO;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class TeamService {

    @Inject
    private TeamMapper teamMapper;
    @Inject
    private TeamDao teamDao;

    public void saveTeam(TeamRequest request) {
        teamDao.saveTeam(teamMapper.mapRequestToEntity(request));
    }

//    TODO
    public void deleteTeam(TeamRequest request) { }

//    TODO
    public void editTeam(TeamRequest teamRequest) {}


    public void getAllTeams (TeamRequest request){}


    public Team findById(Long id) {
        Team team = teamDao.findById(id).orElseThrow();
        return team;
    }

    public List<Team> findAll() {

        List<Team> teams = new ArrayList<>();

        teamDao.findAll();

        return teams;
    }


}
