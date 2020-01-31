package com.infoshare.academy.highfive.mapper.entity;

import com.infoshare.academy.highfive.domain.Team;
import com.infoshare.academy.highfive.dto.request.TeamRequest;
import com.infoshare.academy.highfive.dto.view.TeamView;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class TeamMapper {

    public TeamView mapEntityToView(Team team) {

        TeamView teamView = new TeamView();

        if (team == null) {
            return teamView;
        }

        teamView.setId(team.getId());
        teamView.setTeamName(team.getTeamName());

        return teamView;
    }

    //for save
    public Team mapRequestToEntity(TeamRequest teamRequest) {

        Team team = new Team();
        return mapRequestToEntity(teamRequest, team);
    }

    //for update
    public Team mapRequestToEntity(TeamRequest teamRequest, Team team) {

        team.setTeamName(teamRequest.getTeamName());
        return team;
    }
}