package com.infoshare.academy.highfive.mapper.request;

import com.infoshare.academy.highfive.domain.*;
import com.infoshare.academy.highfive.request.VacationRequest;

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@RequestScoped
public class VacationRequestMapper {

  public VacationRequest mapParamsToRequest(HttpServletRequest request) throws ParseException {

    Date dateFrom = new SimpleDateFormat("dd/mm/yyyy").parse(request.getParameter("dateFrom"));
    Date dateTo = new SimpleDateFormat("dd/mm/yyyy").parse(request.getParameter("dateTo"));

    VacationRequest vacationRequest = new VacationRequest();

    vacationRequest.setEmployeeId((Long) request.getAttribute("id"));
    vacationRequest.setRole((Role) request.getAttribute("role"));
    vacationRequest.setDateFrom(convertToLocalDateViaSqlDate(dateFrom));
    vacationRequest.setDateTo(convertToLocalDateViaSqlDate(dateTo));
    vacationRequest.setVacationStatus(VacationStatus.APPLIED);

    if (request.getParameter("VacationType").equals("parental")) {
      vacationRequest.setVacationType(VacationType.PARENTAL);
    } else if (request.getParameter("VacationType").equals("vacation")) {
      vacationRequest.setVacationType(VacationType.VACATION);
    } else { vacationRequest.setVacationType(VacationType.OCCASIONAL); }

    return vacationRequest;
  }

  public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
    return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
  }


}
