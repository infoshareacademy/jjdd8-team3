package com.infoshare.academy.highfive.mapper.entity;

import com.infoshare.academy.highfive.domain.Team;
import com.infoshare.academy.highfive.request.TeamRequest;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class TeamMapper {

    public Team mapRequestToEntity(TeamRequest request) {

        Team team = new Team();
        team.setId(request.getId());
        team.setTeamName(request.getTeamName());
        return team;
    }
}
