package com.infoshare.academy.highfive.web.api;

import com.infoshare.academy.highfive.dto.view.EmployeeView;
import com.infoshare.academy.highfive.service.VacationService;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;

@Path("/vacation")
public class VacationApi {

  @Inject
  VacationService vacationService;

  @GET
  @Path("/admin/approved-denied-ratio")
  @Produces(MediaType.TEXT_PLAIN)
  public Response getEmployeeApprovedToDeniedRatio() {

    return Response.ok().entity(vacationService.getApprovedToDeniedVacationRatio().toString()).build();

  }

  @GET
  @Path("/admin/taken-by-employee")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getVacationTakenByEmployee() {

    return Response.ok().entity(vacationService.getEmployeesByVacationTaken()).build();

  }

  @GET
  @Path("/admin/taken-by-team")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getVacationTakenByTeam() {

    return Response.ok().entity(vacationService.getTeamByVacationTaken()).build();

  }

  @GET
  @Path("/admin/popular-months")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getPopularMonths() {

    return Response.ok().entity(vacationService.getMonthStatistic()).build();

  }

  @GET
  @Path("/employee/vacation-dates/{start}{end}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getVacationDates(@Context HttpServletRequest httpRequest, @PathParam("start") String start, @PathParam("end") String end) {

    HttpSession session = httpRequest.getSession();
    EmployeeView employee = (EmployeeView) session.getAttribute("loggedEmployee");
    Long id = employee.getId();
    LocalDate startDate = LocalDate.parse(start);
    LocalDate endDate = LocalDate.parse(end);

    return Response.ok().entity(vacationService.getTeamVacationByDatesInRange(id, startDate, endDate)).build();

  }

  @GET
  @Path("/admin/vacations/{start}/{end}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllVacationByDates(@Context HttpServletRequest httpRequest, @PathParam("start") String start, @PathParam("end") String end) {

    LocalDate startDate = LocalDate.parse(start);
    LocalDate endDate = LocalDate.parse(end);

    return Response.ok().entity(vacationService.listAllVacation(startDate, endDate)).build();

  }

}
