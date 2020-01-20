package com.infoshare.academy.highfive.servlet.employee;

import com.infoshare.academy.highfive.freemarker.TemplateProvider;
import com.infoshare.academy.highfive.mapper.request.EmployeeRequestMapper;
import com.infoshare.academy.highfive.dto.request.EmployeeRequest;
import com.infoshare.academy.highfive.service.EmployeeService;
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

@WebServlet("/manager/add-employee")
public class AddEmployeeServlet extends HttpServlet {

    Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private EmployeeRequestMapper requestMapper;

    @EJB
    private EmployeeService employeeService;

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        Map<String, Object> dataModel = new HashMap<>();

        Template template = this.templateProvider.getTemplate(getServletContext(), "template.ftlh");

        dataModel.put("method", req.getMethod());
        dataModel.put("contentTemplate", "add-employee.ftlh");
        dataModel.put("title", "Add new employee");

        logger.info("User (manager) provided with new employee adding form.");

        try {
            template.process(dataModel, writer);
        } catch (
                TemplateException e) {
            logger.warn("Issue with processing Freemarker template.");
            e.getMessage();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            EmployeeRequest employeeRequest = requestMapper.mapParamsToRequest(req);
            employeeService.addNewEmployee(employeeRequest);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
