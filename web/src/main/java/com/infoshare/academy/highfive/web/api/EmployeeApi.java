package com.infoshare.academy.highfive.web.api;

import com.infoshare.academy.highfive.dto.request.EmployeeRequest;
import com.infoshare.academy.highfive.dto.request.HolidayRequest;
import com.infoshare.academy.highfive.exception.JsonFileNotFound;
import com.infoshare.academy.highfive.service.EmployeeService;
import com.infoshare.academy.highfive.service.HolidayService;
import com.infoshare.academy.highfive.service.configuration.UploadJsonService;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Path("/employee")
public class EmployeeApi {

    @EJB
    private EmployeeService employeeService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") Long id) {
        return Response.ok().entity(employeeService.getById(id)).build();
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        return Response.ok().entity(employeeService.listAll()).build();
    }

//    @GET
//    @Path("/list/{name}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response searchByName(@PathParam("name") String name) {
//        return Response.ok().entity(employeeService.(name)).build();
//    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(EmployeeRequest employeeRequest) {

        employeeService.addNewEmployee(employeeRequest);
        return Response.ok().entity(employeeRequest).build();

    }

    @PUT
    @Path("/put/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, EmployeeRequest employeeRequest) {
        employeeService.editEmployee(id, employeeRequest);
        return Response.ok().entity(employeeRequest).build();

    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        return Response.ok().entity(employeeService.deleteEmployee(id)).build();

    }

}
