package com.infoshare.academy.highfive.web.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/health")
public class Health {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response get() {
        return Response.status(200).build();
    }
}
