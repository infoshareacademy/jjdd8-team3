package com.infoshare.academy.highfive.mapper.request;

import com.infoshare.academy.highfive.domain.Role;
import com.infoshare.academy.highfive.request.VacationRequest;

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RequestScoped
public class VacationRequestMapper {

  public VacationRequest mapParamsToRequest(HttpServletRequest request) throws ParseException {

    Date dateFrom = new SimpleDateFormat("dd/mm/yyyy").parse(request.getParameter("dateFrom"));
    Date dateTo = new SimpleDateFormat("dd/mm/yyyy").parse(request.getParameter("dateTo"));
    VacationRequest vacationRequest = new VacationRequest();
    vacationRequest.setId((Long) request.getAttribute("id"));
    vacationRequest.setRole((Role) request.getAttribute("role"));
    vacationRequest.setDateFrom(dateFrom);
    vacationRequest.setDateTo(dateTo);

    return vacationRequest;
  }

}
