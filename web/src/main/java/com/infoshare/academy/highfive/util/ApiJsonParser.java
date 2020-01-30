package com.infoshare.academy.highfive.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.infoshare.academy.highfive.domain.Holiday;
import com.infoshare.academy.highfive.exception.JsonUrlNotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApiJsonParser {

    Logger LOGGER = LoggerFactory.getLogger(getClass().getName());

    private static final String HOLIDAYS = "holidays";
    private static ObjectMapper objectMapper;

    public ApiJsonParser() {
        objectMapper = new ObjectMapper();
        JavaTimeModule module = new JavaTimeModule();
        LocalDateTimeDeserializer localDateTimeDeserializer = new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        module.addDeserializer(LocalDateTime.class, localDateTimeDeserializer);
        objectMapper.registerModule(module);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
    }

    public List<Holiday> parseFromFile(File inputFromFile) throws IOException {
        LOGGER.info("Uploading JSON DATA from local file;");
        return parseJson(objectMapper.readTree(inputFromFile));
    }

    public List<Holiday> parseFromInputStream(InputStream inputStreamFromFile) throws IOException {
        LOGGER.info("Uploading JSON DATA from local file;");
        return parseJson(objectMapper.readTree(inputStreamFromFile));
    }

    public List<Holiday> parseFromURL(String urlPath) throws IOException, JsonUrlNotFound {

        LOGGER.info("Connecting to url API for JSON DATA;");
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(urlPath);

        int status = 0;

        try {
            Response response = target.request().get();
            status = response.getStatus();
        } catch (Exception e) {
            LOGGER.debug("Service is not responding; {}", e);
            throw new JsonUrlNotFound("Service is not responding");
        }

        if (status != 200) {
            LOGGER.debug("No valid url or API is down! status {}", status);
            throw new JsonUrlNotFound("Service is not responding");
        }

        LOGGER.debug("Connecting to URL API for JSON data. Connection status: {}", status);
        return parseJson(objectMapper.readTree(new URL(urlPath)));
    }

    private List<Holiday> parseJson(JsonNode jsonNodeBase) {
        Holiday[] holidayImport = {};
        try {
            JsonNode jsonData = jsonNodeBase.findPath(HOLIDAYS);
            holidayImport = objectMapper.treeToValue(jsonData, Holiday[].class);
            LOGGER.info("Holidays from JSON imported to Holiday entity! total entities parsed {}", holidayImport.length);
        } catch (JsonProcessingException e) {
            LOGGER.info("Error with parsing JSON to entity!\n", e);
        }

        return new ArrayList<>(Arrays.asList(holidayImport));
    }

}
