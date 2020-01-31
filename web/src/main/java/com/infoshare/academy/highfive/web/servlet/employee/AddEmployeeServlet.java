package com.infoshare.academy.highfive.web.servlet.employee;

import com.infoshare.academy.highfive.domain.Role;
import com.infoshare.academy.highfive.freemarker.TemplateProvider;
import com.infoshare.academy.highfive.service.EmployeeService;
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

@WebServlet("/manager/add-employee")
public class AddEmployeeServlet extends HttpServlet {

    Logger LOGGER = LoggerFactory.getLogger(getClass().getName());

    @EJB
    private EmployeeService employeeService;

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private TeamService teamService;

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
        dataModel.put("contentTemplate", "add-employee.ftlh");

        if (action.equals("edit")) {
            dataModel.put("action", "edit");
            dataModel.put("employee", employeeService.findById(Long.parseLong(id)));
        } else {
            dataModel.put("title", "Add employee");
            dataModel.put("action", "add");
        }
        dataModel.put("teams", teamService.listAll());
        dataModel.put("roles", Role.values());
        dataModel.put("pluginCssTemplate", "plugin-css-stylesheet.ftlh");
        dataModel.put("pluginJsTemplate", "plugin-js-add-employee.ftlh");

        LOGGER.info("User (manager) provided with new employee adding form.");

        try {
            template.process(dataModel, writer);
        } catch (
                TemplateException e) {
            LOGGER.warn("Issue with processing Freemarker template.");
            e.getMessage();
        }
    }
}