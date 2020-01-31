package com.infoshare.academy.highfive.web.servlet.vacation;

import com.infoshare.academy.highfive.domain.VacationStatus;
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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("manager/approve-request")
public class ApproveVacationRequestServlet extends HttpServlet {

  Logger LOGGER = LoggerFactory.getLogger(getClass().getName());

  @Inject
  private TemplateProvider templateProvider;

  @Inject
  VacationService vacationService;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    Long id = Long.valueOf(req.getParameter("vacation_id"));
    vacationService.changeVacationStatus(id, VacationStatus.APPROVED);

    Template template = this.templateProvider.getTemplate(getServletContext(), "template.ftlh");

    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter writer = resp.getWriter();
    Map<String, Object> dataModel = new HashMap<>();

    dataModel.put("contentTemplate", "pending-vacation-approval.ftlh");
    dataModel.put("title", "Success!");


    try {
      template.process(dataModel, writer);
    } catch (
      TemplateException e) {
      LOGGER.error(e.getMessage(), e);
    }

  }

}
