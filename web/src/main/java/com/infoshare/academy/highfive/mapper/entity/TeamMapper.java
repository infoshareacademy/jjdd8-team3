package com.infoshare.academy.highfive.mapper.entity;

import com.infoshare.academy.highfive.domain.Team;
import com.infoshare.academy.highfive.dto.request.TeamRequest;
import com.infoshare.academy.highfive.dto.view.TeamView;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class TeamMapper {

    public Team mapRequestToEntity(TeamRequest request) {

        Team team = new Team();
        team.setTeamName(request.getTeamName());
        return team;
    }

    public TeamView mapEntityToView(Team team) {

        TeamView teamView = new TeamView();

        if (team == null) {
            return teamView;
        }

        teamView.setId(team.getId());
        teamView.setTeamName(team.getTeamName());

        return teamView;
    }
}
