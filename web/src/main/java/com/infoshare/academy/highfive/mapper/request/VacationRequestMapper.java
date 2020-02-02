package com.infoshare.academy.highfive.mapper.request;

import com.infoshare.academy.highfive.domain.Role;
import com.infoshare.academy.highfive.domain.VacationStatus;
import com.infoshare.academy.highfive.domain.VacationType;
import com.infoshare.academy.highfive.dto.request.VacationRequest;
import com.infoshare.academy.highfive.dto.view.EmployeeView;

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RequestScoped
public class VacationRequestMapper {

  public VacationRequest mapParamsToRequest(HttpServletRequest request) throws ParseException {

    HttpSession session = request.getSession();

    LocalDate dateFrom = LocalDate.parse(request.getParameter("date_from"));
    LocalDate dateTo = LocalDate.parse(request.getParameter("date_to"));
    EmployeeView employee = (EmployeeView) session.getAttribute("loggedEmployee");
    LocalDateTime dateOfRequest = LocalDateTime.now();
    String reminderEmailSent = "0";

    VacationRequest vacationRequest = new VacationRequest();
    vacationRequest.setEmployeeId(employee.getId());
    vacationRequest.setRole((Role) request.getAttribute("role"));
    vacationRequest.setDateFrom(dateFrom);
    vacationRequest.setDateTo(dateTo);
    vacationRequest.setVacationStatus(VacationStatus.APPLIED);
    vacationRequest.setDateOfRequest(dateOfRequest);
    vacationRequest.setReminderEmailSent(reminderEmailSent);


    if (request.getParameter("vacation_type").equals("parental")) {
      vacationRequest.setVacationType(VacationType.PARENTAL);
    } else if (request.getParameter("vacation_type").equals("vacation")) {
      vacationRequest.setVacationType(VacationType.VACATION);
    } else {
      vacationRequest.setVacationType(VacationType.ON_DEMAND);
    }

    return vacationRequest;

  }

}
