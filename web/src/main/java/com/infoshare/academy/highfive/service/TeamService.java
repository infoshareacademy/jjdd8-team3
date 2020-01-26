package com.infoshare.academy.highfive.service;

import com.infoshare.academy.highfive.dao.TeamDao;
import com.infoshare.academy.highfive.domain.Team;
import com.infoshare.academy.highfive.dto.view.TeamView;
import com.infoshare.academy.highfive.mapper.entity.EmployeeMapper;
import com.infoshare.academy.highfive.mapper.entity.TeamMapper;
import com.infoshare.academy.highfive.dto.request.TeamRequest;

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

    public void save(TeamRequest request) {
        teamDao.save(teamMapper.mapRequestToEntity(request));
    }

    public void update(Long id, TeamRequest teamRequest) {
        Team team = teamDao.getById(id).orElseThrow();

        teamMapper.mapRequestToEntity(teamRequest, team);
        teamDao.update(team);
    }

    public TeamView remove(Long id){
        TeamView teamView = teamMapper.mapEntityToView(teamDao.delete(id));
        return teamView;
    }

    public TeamView findById(Long id) {
        Team team = teamDao.getById(id).orElseThrow();
        return teamMapper.mapEntityToView(team);
    }

    public List<TeamView> listAll() {
        List<TeamView> allTeamsView = new ArrayList<>();
        teamDao.listAllTeam()
                .forEach(team -> allTeamsView.add(teamMapper.mapEntityToView(team)));
        return allTeamsView;
    }


}