package com.infoshare.academy.highfive.web.servlet.vacation;

import com.infoshare.academy.highfive.dto.request.VacationRequest;
import com.infoshare.academy.highfive.dto.view.EmployeeView;
import com.infoshare.academy.highfive.freemarker.TemplateProvider;
import com.infoshare.academy.highfive.mapper.entity.EmployeeMapper;
import com.infoshare.academy.highfive.mapper.request.VacationRequestMapper;
import com.infoshare.academy.highfive.service.VacationService;
import com.infoshare.academy.highfive.service.configuration.MailSender;
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
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("employee/request-vacation")
public class RequestVacationServlet extends HttpServlet {

  Logger LOGGER = LoggerFactory.getLogger(getClass().getName());

  @Inject
  private TemplateProvider templateProvider;

  @Inject
  private VacationRequestMapper vacationRequestMapper;

  @Inject
  VacationService vacationService;

  @Inject
  MailSender mailSender;

  @Inject
  EmployeeMapper employeeMapper;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    resp.setContentType("text/html;charset=UTF-8");

    PrintWriter writer = resp.getWriter();
    HttpSession session = req.getSession();
    Map<String, Object> dataModel = new HashMap<>();

    Template template = this.templateProvider.getTemplate(getServletContext(), "template.ftlh");

    EmployeeView employee = (EmployeeView) session.getAttribute("loggedEmployee");
    Long id = employee.getId();


    dataModel.put("method", req.getMethod());
    dataModel.put("contentTemplate", "request-vacation.ftlh");
    dataModel.put("title", "Request vacation");
    dataModel.put("loggedEmployee", session.getAttribute("loggedEmployee"));
    dataModel.put("loggedEmployeeRole", session.getAttribute("loggedEmployeeRole"));
    dataModel.put("entitlementVacation", vacationService.getVacationEntitlement(employeeMapper.mapViewToEntity(employee)));
    dataModel.put("entitlementOnDemand", vacationService.getOnDemandEntitlement(employeeMapper.mapViewToEntity(employee)));
    dataModel.put("entitlementParental", vacationService.getParentalEntitlement(employeeMapper.mapViewToEntity(employee)));

    LOGGER.info("User provided with vacation form.");

    try {
      template.process(dataModel, writer);
    } catch (
      TemplateException e) {
      LOGGER.error(e.getMessage(), e);
    }

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    try {

      VacationRequest vacationRequest = vacationRequestMapper.mapParamsToRequest(req);
      this.vacationService.addVacation(vacationRequest);

      Template template = this.templateProvider.getTemplate(getServletContext(), "template.ftlh");

      resp.setContentType("text/html;charset=UTF-8");
      PrintWriter writer = resp.getWriter();
      Map<String, Object> dataModel = new HashMap<>();

      LOGGER.debug("Status {}", vacationService.getStatus());

      HttpSession session = req.getSession();

      if (vacationService.getStatus().equals("ok")) {

        dataModel.put("contentTemplate", "request-vacation-success.ftlh");
        dataModel.put("title", "Success!");
        dataModel.put("loggedEmployee", session.getAttribute("loggedEmployee"));
        dataModel.put("loggedEmployeeRole", session.getAttribute("loggedEmployeeRole"));
        mailSender.sendNotification(vacationRequest, "jjdd8highfive@gmail.com");

      } else if (vacationService.getStatus().equals("exceeding_entitlement")) {

        dataModel.put("contentTemplate", "request-vacation-exceeding-entitlement.ftlh");
        dataModel.put("title", "Given days are exceeding entitlement.");
        dataModel.put("loggedEmployee", session.getAttribute("loggedEmployee"));
        dataModel.put("loggedEmployeeRole", session.getAttribute("loggedEmployeeRole"));

      } else {

        dataModel.put("contentTemplate", "request-vacation-wrong-date.ftlh");
        dataModel.put("title", "Wrong dates given.");
        dataModel.put("loggedEmployee", session.getAttribute("loggedEmployee"));
        dataModel.put("loggedEmployeeRole", session.getAttribute("loggedEmployeeRole"));

      }

      try {
        template.process(dataModel, writer);
      } catch (
        TemplateException e) {
        LOGGER.error(e.getMessage(), e);
      }


    } catch (ParseException e) {
      LOGGER.error(e.getMessage(), e);
    }

  }

}

