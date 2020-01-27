package com.infoshare.academy.highfive.web.servlet.employee;

import com.infoshare.academy.highfive.freemarker.TemplateProvider;
import com.infoshare.academy.highfive.service.EmployeeService;
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

@WebServlet ("/list-employees")
public class EmployeeListServlet extends HttpServlet {

    Logger LOGGER = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private EmployeeService employeeService;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        Map<String, Object> dataModel = new HashMap<>();
        Template template = this.templateProvider.getTemplate(getServletContext(),"template.ftlh");

        dataModel.put("method", req.getMethod());
        dataModel.put("contentTemplate", "all-employee.ftlh");
        dataModel.put("title", "List Employees");
        dataModel.put("pluginCssTemplate", "plugin-css-stylesheet.ftlh");
        dataModel.put("pluginJsTemplate", "plugin-js-servlets.ftlh");
        dataModel.put("employees", employeeService.listAll());

        try{
            template.process(dataModel, writer);
        } catch (
                TemplateException e) {
            LOGGER.warn("Issue with processing Freemarker template.{}", e.getMessage());
        }
    }
}
