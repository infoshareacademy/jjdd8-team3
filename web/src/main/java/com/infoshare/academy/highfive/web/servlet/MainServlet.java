package com.infoshare.academy.highfive.web.servlet;

import com.infoshare.academy.highfive.freemarker.TemplateProvider;
import com.infoshare.academy.highfive.service.EmployeeService;
import com.infoshare.academy.highfive.service.VacationService;
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

@WebServlet("")
public class MainServlet extends HttpServlet {

  Logger LOGGER = LoggerFactory.getLogger(getClass().getName());

  @Inject
  private TemplateProvider templateProvider;

  @Inject
  VacationService vacationService;

  @Inject
  EmployeeService employeeService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    resp.setContentType("text/html;charset=UTF-8");

    PrintWriter writer = resp.getWriter();

    Map<String, Object> dataModel = new HashMap<>();

    Template template = this.templateProvider.getTemplate(getServletContext(), "template.ftlh");

    dataModel.put("method", req.getMethod());
    dataModel.put("contentTemplate", "main-content.ftlh");
    dataModel.put("title", "Vacation Manager");
    dataModel.put("pluginJsTemplate", "plugin-js-main-content.ftlh");
    dataModel.put("currentMonthTotal", vacationService.getStatistics().getCurrentMonthTotal());
    dataModel.put("nextMonthTotal", vacationService.getStatistics().getNextMonthTotal());
    dataModel.put("absentToday", vacationService.getStatistics().getAbsentToday());
    dataModel.put("totalEmployees", employeeService.listAllSize());
    dataModel.put("pendingRequests", vacationService.getStatistics().getPendingRequests());

    try {
      template.process(dataModel, writer);
    } catch (
      TemplateException e) {
      LOGGER.warn("Issue with processing Freemarker template.{}", e.getMessage());
    }

  }
}
