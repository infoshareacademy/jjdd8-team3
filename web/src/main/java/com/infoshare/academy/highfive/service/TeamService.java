package com.infoshare.academy.highfive.service;

import com.infoshare.academy.highfive.dao.TeamDao;
import com.infoshare.academy.highfive.domain.Team;
import com.infoshare.academy.highfive.mapper.entity.TeamMapper;
import com.infoshare.academy.highfive.request.TeamRequest;

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

//    public void deleteTeam(TeamRequest request) {
//        teamDao.deleteTeam(teamMapper.mapRequestToEntity(request));}

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
