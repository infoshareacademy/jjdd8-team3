package com.infoshare.academy.highfive.web.servlet.vacation;

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

@WebServlet("employee/withdraw-vacation")
public class WithrawVacationServlet extends HttpServlet {

  Logger LOGGER = LoggerFactory.getLogger(getClass().getName());

  @Inject
  VacationService vacationService;

  @Inject
  TemplateProvider templateProvider;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    Long id = Long.valueOf(req.getParameter("vacation_id"));
    vacationService.removeVacation(id);

    Template template = this.templateProvider.getTemplate(getServletContext(), "template.ftlh");

    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter writer = resp.getWriter();
    HttpSession session = req.getSession();
    Map<String, Object> dataModel = new HashMap<>();

    dataModel.put("contentTemplate", "vacation-withdrawal.ftlh");
    dataModel.put("title", "Success!");

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
