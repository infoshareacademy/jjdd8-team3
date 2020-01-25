package com.infoshare.academy.highfive.web.servlet.team;

import com.infoshare.academy.highfive.freemarker.TemplateProvider;
import com.infoshare.academy.highfive.service.TeamService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private TeamService teamService;

    @Inject
    private TemplateProvider templateProvider;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String action = req.getParameter("action");
        String id = req.getParameter("get");

        if (action == null || action.isEmpty()) {
            action = "add";
        }

        PrintWriter writer = resp.getWriter();

        Map<String, Object> dataModel = new HashMap<>();

        Template template = this.templateProvider.getTemplate(getServletContext(), "template.ftlh");

        dataModel.put("method", req.getMethod());
        dataModel.put("contentTemplate", "add-team.ftlh");

        if (action.equals("edit")) {
            dataModel.put("action", "edit");
            dataModel.put("team", teamService.findById(Long.parseLong(id)));
        } else {
            dataModel.put("title", "Add team");
            dataModel.put("action", "add");
        }
        dataModel.put("pluginCssTemplate", "plugin-css-add-holiday.ftlh");
        dataModel.put("pluginJsTemplate", "plugin-js-add-team.ftlh");

        try {
            template.process(dataModel, writer);
        } catch (
                TemplateException e) {
            LOGGER.warn("Issue with processing Freemarker template.");
            e.getMessage();
        }
    }
}
