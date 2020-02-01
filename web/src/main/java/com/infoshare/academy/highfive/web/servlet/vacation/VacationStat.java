package com.infoshare.academy.highfive.web.servlet.vacation;

import com.infoshare.academy.highfive.freemarker.TemplateProvider;
import com.infoshare.academy.highfive.service.EmployeeService;
import com.infoshare.academy.highfive.service.VacationService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/employee/statistics")
public class VacationStat extends HttpServlet {

  Logger LOGGER = LoggerFactory.getLogger(getClass().getName());

  @Inject
  private TemplateProvider templateProvider;

  @Inject
  VacationService vacationService;

  @Inject
  EmployeeService employeeService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {

    resp.setContentType("text/html;charset=UTF-8");

    PrintWriter writer = resp.getWriter();

    Map<String, Object> dataModel = new HashMap<>();

    Template template = this.templateProvider.getTemplate(getServletContext(), "template.ftlh");

    dataModel.put("method", req.getMethod());
    dataModel.put("contentTemplate", "stat-content.ftlh");
    dataModel.put("title", "Vacation Statistic");
    dataModel.put("pluginJsTemplate", "plugin-js-stat-content.ftlh");
    dataModel.put("currentMonthTotal", vacationService.getDashboardStatistic().getCurrentMonthTotal());
    dataModel.put("nextMonthTotal", vacationService.getDashboardStatistic().getNextMonthTotal());
    dataModel.put("absentToday", vacationService.getDashboardStatistic().getAbsentToday());
    dataModel.put("totalEmployees", employeeService.listAllSize());
    dataModel.put("pendingRequests", vacationService.getDashboardStatistic().getPendingRequests());

    try {
      template.process(dataModel, writer);
    } catch (
      TemplateException e) {
      LOGGER.warn("Issue with processing Freemarker template.{}", e.getMessage());
    }

  }

}
