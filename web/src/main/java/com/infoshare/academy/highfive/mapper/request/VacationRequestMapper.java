package com.infoshare.academy.highfive.mapper.request;

import com.infoshare.academy.highfive.domain.Role;
import com.infoshare.academy.highfive.domain.VacationStatus;
import com.infoshare.academy.highfive.domain.VacationType;
import com.infoshare.academy.highfive.dto.request.VacationRequest;

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RequestScoped
public class VacationRequestMapper {

  public VacationRequest mapParamsToRequest(HttpServletRequest request) throws ParseException {

    LocalDate dateFrom = LocalDate.parse(request.getParameter("date_from"));
    LocalDate dateTo = LocalDate.parse(request.getParameter("date_to"));
    LocalDateTime dateOfRequest = LocalDateTime.now();

    VacationRequest vacationRequest = new VacationRequest();
    vacationRequest.setEmployeeId(Long.parseLong(request.getParameter("employee_id")));
    vacationRequest.setRole((Role) request.getAttribute("role"));
    vacationRequest.setDateFrom(dateFrom);
    vacationRequest.setDateTo(dateTo);
    vacationRequest.setVacationStatus(VacationStatus.APPLIED);
    vacationRequest.setDateOfRequest(dateOfRequest);
    vacationRequest.setReminderEmailSent(false);


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
