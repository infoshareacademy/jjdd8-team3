package com.infoshare.academy.highfive.mapper.request;


import com.infoshare.academy.highfive.domain.Role;
import com.infoshare.academy.highfive.domain.Team;
import com.infoshare.academy.highfive.request.EmployeeRequest;
import com.infoshare.academy.highfive.request.TeamRequest;

import javax.enterprise.context.RequestScoped;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RequestScoped
public class EmployeeRequestMapper {

  public EmployeeRequest mapParamsToRequest(HttpServletRequest request) throws ParseException {

    EmployeeRequest employeeRequest = new EmployeeRequest();
    LocalDate hireDate = LocalDate.parse(request.getParameter("hire_date"), DateTimeFormatter.ofPattern("dd/mm/yyyy"));

    employeeRequest.setId((Long) request.getAttribute("id"));
    employeeRequest.setFirstName((String) request.getAttribute("first_name"));
    employeeRequest.setSurname((String) request.getAttribute("surname"));
    employeeRequest.setHireDate(hireDate);
    employeeRequest.setHolidayEntitlement((Integer) request.getAttribute("holiday_entitlement"));
    employeeRequest.setAdditionalEntitlement((Integer) request.getAttribute("additional_entitlement"));
    employeeRequest.setLogin((String) request.getAttribute("login"));
    employeeRequest.setEmail((String) request.getAttribute("email"));
    employeeRequest.setPosition((String) request.getAttribute("position"));
    employeeRequest.setTeam((Team) request.getAttribute("team_id"));
    employeeRequest.setRole((Role) request.getAttribute("role"));

    return employeeRequest;
  }
}
