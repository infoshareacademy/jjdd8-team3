package com.infoshare.academy.highfive.web.api;

import com.infoshare.academy.highfive.dto.request.TeamRequest;
import com.infoshare.academy.highfive.service.TeamService;
import com.infoshare.academy.highfive.service.configuration.UploadJsonService;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/team")
public class TeamApi {

    @EJB
    private TeamService teamService;

    @Inject
    private UploadJsonService uploadJsonService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") Long id) {
        return Response.ok().entity(teamService.findById(id)).build();
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        return Response.ok().entity(teamService.listAll()).build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(TeamRequest teamRequest) {

        teamService.save(teamRequest);
        return Response.ok().entity(teamRequest).build();

    }

    @PUT
    @Path("/put/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, TeamRequest teamRequest) {

        teamService.update(id, teamRequest);
        return Response.ok().entity(teamRequest).build();

    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        return Response.ok().entity(teamService.remove(id)).build();

    }
}
