package com.infoshare.academy.highfive.mapper.request;


import com.infoshare.academy.highfive.request.TeamRequest;

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;

@RequestScoped
public class TeamRequestMapper {

  public TeamRequest mapParamsToRequest(HttpServletRequest request) {

    TeamRequest teamRequest = new TeamRequest();

    teamRequest.setId((Long) request.getAttribute("team_id"));
    teamRequest.setTeamName((String) request.getAttribute("team_name"));

    return teamRequest;
  }
}
