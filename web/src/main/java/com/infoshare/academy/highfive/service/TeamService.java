package com.infoshare.academy.highfive.service;

import com.infoshare.academy.highfive.dao.TeamDao;
import com.infoshare.academy.highfive.mapper.entity.TeamMapper;
import com.infoshare.academy.highfive.dto.request.TeamRequest;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class TeamService {

    @Inject
    private TeamMapper teamMapper;
    @Inject
    private TeamDao teamDao;

    public void addNewTeam(TeamRequest request) {
        teamDao.addTeam(teamMapper.mapRequestToEntity(request));
    }

    public void editTeam(TeamRequest request) {
        teamDao.editTeam(teamMapper.mapRequestToEntity(request));
    }

    public void deleteTeam(TeamRequest request) {
        teamDao.deleteTeam(teamMapper.mapRequestToEntity(request));
    }

}
