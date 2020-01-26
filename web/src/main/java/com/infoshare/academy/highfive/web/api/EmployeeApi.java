package com.infoshare.academy.highfive.web.api;

import com.infoshare.academy.highfive.dto.request.EmployeeRequest;
import com.infoshare.academy.highfive.dto.request.TeamRequest;
import com.infoshare.academy.highfive.service.EmployeeService;
import com.infoshare.academy.highfive.service.configuration.UploadJsonService;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/employee")
public class EmployeeApi {

    @EJB
    private EmployeeService employeeService;

    @Inject
    private UploadJsonService uploadJsonService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") Long id) {
        return Response.ok().entity(employeeService.findById(id)).build(); }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        return Response.ok().entity(employeeService.listAll()).build(); }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(EmployeeRequest employeeRequest) {

        employeeService.addNew(employeeRequest);
        return Response.ok().entity(employeeRequest).build();
    }

    @PUT
    @Path("/put/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, EmployeeRequest employeeRequest) {

        employeeService.update(id, employeeRequest);
        return Response.ok().entity(employeeRequest).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        return Response.ok().entity(employeeService.remove(id)).build();
    }
}
