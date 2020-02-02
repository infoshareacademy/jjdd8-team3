package com.infoshare.academy.highfive.web.servlet.vacation;

import com.infoshare.academy.highfive.dto.view.EmployeeView;
import com.infoshare.academy.highfive.freemarker.TemplateProvider;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("employee/withdraw-request")
public class VacationListServlet extends HttpServlet {

  Logger LOGGER = LoggerFactory.getLogger(getClass().getName());

  @Inject
  private TemplateProvider templateProvider;

  @Inject
  VacationService vacationService;

  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter writer = resp.getWriter();
    HttpSession session = req.getSession();
    Map<String, Object> dataModel = new HashMap<>();

    Template template = this.templateProvider.getTemplate(getServletContext(), "template.ftlh");

    EmployeeView employee = (EmployeeView) session.getAttribute("loggedEmployee");
    Long id = employee.getId();
    dataModel.put("method", req.getMethod());
    dataModel.put("contentTemplate", "requested-vacation.ftlh");
    dataModel.put("title", "Vacation");
    dataModel.put("vacations", vacationService.listAllEmployeeVacation(id));
    dataModel.put("pluginCssTemplate", "plugin-css-stylesheet.ftlh");
    dataModel.put("pluginJsTemplate", "plugin-js-servlets.ftlh");

    dataModel.put("loggedEmployee", session.getAttribute("loggedEmployee"));
    dataModel.put("loggedEmployeeRole", session.getAttribute("loggedEmployeeRole"));

    try {
      template.process(dataModel, writer);
    } catch (
      TemplateException e) {
      LOGGER.error(e.getMessage(), e);
    }

  }

}
