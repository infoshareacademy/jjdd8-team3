//package com.infoshare.academy.highfive.servlet;
//
//import com.infoshare.academy.highfive.mapper.request.AddTeamRequestMapper;
//import com.infoshare.academy.highfive.request.AddTeamRequest;
//import com.infoshare.academy.highfive.service.TeamService;
//
//import javax.ejb.EJB;
//import javax.inject.Inject;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet("/manager/add-team/")
//public class AddTeamServlet extends HttpServlet {
//
//    @Inject
//    private AddTeamRequestMapper addTeamRequestMapper;
//
//    @Inject
//    private TeamService teamService;
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        AddTeamRequest addTeamRequest = addTeamRequestMapper.mapParamsToRequest(req);
//
//    }
//}
