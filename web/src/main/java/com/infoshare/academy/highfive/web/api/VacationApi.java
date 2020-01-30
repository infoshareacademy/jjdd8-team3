package com.infoshare.academy.highfive.web.api;

import com.infoshare.academy.highfive.service.VacationService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/vacation")
public class VacationApi {

  @Inject
  VacationService vacationService;

  @GET
  @Path("/takenByEmployee")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getVacationTakenByEmployee() {
    return Response.ok().entity(vacationService.getEmployeesByVacationTaken()).build();
  }

  @GET
  @Path("/approvedToDeniedRatio")
  @Produces(MediaType.TEXT_PLAIN)
  public Response getEmployeeApprovedToDeniedRatio() {
    return Response.ok().entity(vacationService.getApprovedToDeniedVacationRatio().toString()).build();
  }

  @GET
  @Path("/takenByTeam")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getVacationTakenByTeam() {
    return Response.ok().entity(vacationService.getTeamByVacationTaken()).build();
  }

  @GET
  @Path("/popularMonths")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getPopularMonths() {
    return Response.ok().entity(vacationService.getMonthStatistic()).build();
  }

}
