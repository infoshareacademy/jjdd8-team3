package com.infoshare.academy.highfive.web.servlet.team;

import com.infoshare.academy.highfive.freemarker.TemplateProvider;
import com.infoshare.academy.highfive.mapper.request.TeamRequestMapper;
import com.infoshare.academy.highfive.dto.request.TeamRequest;
import com.infoshare.academy.highfive.service.TeamService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
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
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/manager/add-team")
public class AddTeamServlet extends HttpServlet {

    Logger LOGGER = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private TeamRequestMapper requestMapper;

    @EJB
    private TeamService teamService;

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        Map<String, Object> dataModel = new HashMap<>();

        Template template = this.templateProvider.getTemplate(getServletContext(), "template.ftlh");

        dataModel.put("method", req.getMethod());
        dataModel.put("contentTemplate", "add-team.ftlh");
        dataModel.put("title", "Define new team");

        LOGGER.info("User (manager) provided with team defining form.");

        try {
            template.process(dataModel, writer);
        } catch (
                TemplateException e) {
            LOGGER.warn("Issue with processing Freemarker template.");
            e.getMessage();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TeamRequest teamRequest = requestMapper.mapParamsToRequest(req);
        this.teamService.saveTeam(teamRequest);

//        TODO
//                Prepare confirmation communication for client/user. It may be a list of teams as well
//        resp.sendRedirect("/well-done");

        Template template = this.templateProvider.getTemplate(getServletContext(), "template.ftlh");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        Map<String, Object> dataModel = new HashMap<>();

//        dataModel.put("method", req.getMethod());
        dataModel.put("contentTemplate", "add-team.ftlh");
        dataModel.put("title", "Define new team");
    }
}