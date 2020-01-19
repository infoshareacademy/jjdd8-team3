package com.infoshare.academy.highfive.service;

import com.infoshare.academy.highfive.dao.TeamDao;
import com.infoshare.academy.highfive.domain.Employee;
import com.infoshare.academy.highfive.domain.Team;
import com.infoshare.academy.highfive.dto.request.EmployeeRequest;
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
    @Inject
    private EmployeeMapper employeeMapper;

    private String status;

    public String getStatus() {
        return status;
    }

    public void saveTeam(TeamRequest request) {
        teamDao.saveTeam(teamMapper.mapRequestToEntity(request));
    }

    //    TODO
    public void deleteTeam(TeamRequest request) {
    }

    //    TODO
    public void editTeam(TeamRequest request) {
    }

    public TeamView findById(Long id) {
        Team team = teamDao.findById(id).orElseThrow();
        return teamMapper.mapEntityToView(team);
    }

    public List<TeamView> findAll() {

        List<TeamView> teamViews = new ArrayList<>();

        teamDao.findAll().forEach(employee -> teamViews.add(teamMapper.mapEntityToView(employee)));

        return teamViews;
    }
}
