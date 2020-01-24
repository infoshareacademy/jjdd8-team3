package com.infoshare.academy.highfive.web.api;

import com.infoshare.academy.highfive.service.VacationService;

import javax.inject.Inject;
import javax.json.JsonObject;
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
  @Path("/statistics")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getVacationStatistics() {
    return Response.ok().entity(vacationService.getStatistics()).build();
  }


}
