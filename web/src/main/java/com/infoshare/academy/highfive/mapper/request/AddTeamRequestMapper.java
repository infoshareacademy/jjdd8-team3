package com.infoshare.academy.highfive.mapper.request;


import com.infoshare.academy.highfive.request.AddTeamRequest;

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;

@RequestScoped
public class AddTeamRequestMapper {

  public AddTeamRequest mapParamsToRequest(HttpServletRequest request) {

    AddTeamRequest addTeamRequest = new AddTeamRequest();

    addTeamRequest.setId(Long.valueOf(request.getParameter("id")));
    addTeamRequest.setTeamName(request.getParameter("name"));

    return addTeamRequest;
  }
}
