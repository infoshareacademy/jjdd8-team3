package com.infoshare.academy.highfive.api;

import com.infoshare.academy.highfive.domain.Holiday;
import com.infoshare.academy.highfive.exception.JsonFileNotFound;
import com.infoshare.academy.highfive.service.configuration.UploadJsonService;
import com.infoshare.academy.highfive.service.holiday.HolidayService;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Path("/holiday")
public class HolidayApi {

    @Inject
    private HolidayService holidayService;

    @Inject
    private UploadJsonService uploadJsonService;

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") Long id) {
        return Response.ok().entity(holidayService.finById(id)).build();
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        return Response.ok().entity(holidayService.listAllHolidayViews()).build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response create(Holiday holiday) {
            holidayService.saveHoliday(holiday);
            return Response.ok().entity("Operation successful").build();
    }

    @POST
    @Path("/upload")
    @Consumes("multipart/form-data")
    @Produces(MediaType.TEXT_PLAIN)
    public Response post(MultipartFormDataInput input) {

        String fileName = "";
        Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
        List<InputPart> inputParts = uploadForm.get("file-name");

        Integer importedListSize = 0;
        for (InputPart inputPart : inputParts) {

            try {

                MultivaluedMap<String, String> header = inputPart.getHeaders();
                fileName = getFileName(header);

                InputStream uploadedInputStream = inputPart.getBody(InputStream.class, null);

                try {
                    importedListSize = uploadJsonService.uploadJsonHoliday(uploadedInputStream);
                } catch (JsonFileNotFound jsonFileNotFound) {
                    jsonFileNotFound.printStackTrace();
                }

                if (uploadedInputStream == null)
                    return Response.status(400).entity("Invalid form data").build();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return Response.status(200)
                .entity("File <b>"
                        + fileName
                        + "</b> uploaded with no errors!"
                        + "<br />" + importedListSize + " holidays added to database!").build();
    }


    private String getFileName(MultivaluedMap<String, String> header) {

        String[] contentDisposition = header.getFirst("Content-Disposition").split(";");

        for (String filename : contentDisposition) {
            if ((filename.trim().startsWith("filename"))) {

                String[] name = filename.split("=");

                String finalFileName = name[1].trim().replaceAll("\"", "");
                return finalFileName;
            }
        }
        return "unknown";
    }

}
