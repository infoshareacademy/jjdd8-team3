package com.infoshare.academy.highfive.web.servlet.employee;

import com.infoshare.academy.highfive.freemarker.TemplateProvider;
import com.infoshare.academy.highfive.mapper.request.EmployeeRequestMapper;
import com.infoshare.academy.highfive.dto.request.EmployeeRequest;
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
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/manager/edit-employee")
public class EditEmployeeServlet extends HttpServlet {

    Logger LOGGER = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private EmployeeRequestMapper requestMapper;

    @EJB
    private EmployeeService employeeService;

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private TeamService teamService;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF8");
        PrintWriter writer = resp.getWriter();
        Map<String, Object> dataModel = new HashMap<>();
        Template template = this.templateProvider
                .getTemplate(getServletContext(), "template.ftlh");

        dataModel.put("method", req.getMethod());
        dataModel.put("contentTemplate", "edit-employee.ftlh");
        dataModel.put("title", "List Employees");
        dataModel.put("pluginCssTemplate", "plugin-css-edit-employee.ftlh");
        dataModel.put("pluginJsTemplate", "plugin-js-edit-employee.ftlh");
        dataModel.put("employees", employeeService.listAll());
        dataModel.put("teams", teamService.listAll());

        try{
            template.process(dataModel, writer);
        } catch (
                TemplateException e) {
            LOGGER.warn("Issue with processing Freemarker template.{}", e.getMessage());
        }
    }
}