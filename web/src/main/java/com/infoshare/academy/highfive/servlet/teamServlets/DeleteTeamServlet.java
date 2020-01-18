package com.infoshare.academy.highfive.servlet.teamServlets;

import com.infoshare.academy.highfive.mapper.request.TeamRequestMapper;
import com.infoshare.academy.highfive.request.TeamRequest;
import com.infoshare.academy.highfive.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/manager/delete-team/")
public class DeleteTeamServlet extends HttpServlet {

    Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private TeamRequestMapper requestMapper;

    @EJB
    private TeamService teamService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TeamRequest teamRequest = requestMapper.mapParamsToRequest(req);
        teamService.deleteTeam(teamRequest);
    }
}
