package com.infoshare.academy.highfive.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.infoshare.academy.highfive.domain.Holiday;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

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
        logger.info("Uploading JSON DATA from local file;");
        //return parseJson(objectMapper.readTree(inputFromFile));
        return parseJson(objectMapper.readTree(inputFromFile));
    }

    public List<Holiday> parseFromURL(String urlPath) throws IOException {
        logger.info("Connecting to API for JSON DATA;");
        return parseJson(objectMapper.readTree(new URL(urlPath)));
    }

    private List<Holiday> parseJson(JsonNode jsonNodeBase) {
        Holiday[] holidayImport = {};
        try {
            JsonNode jsonData = jsonNodeBase.findPath(HOLIDAYS);
            holidayImport = objectMapper.treeToValue(jsonData, Holiday[].class);
            logger.info("Holidays from JSON imported to Holiday entity!");
        } catch (JsonProcessingException e) {
            logger.info("Error with obtaining JSON with Holidays!\n", e);
        }
        return new ArrayList<>(Arrays.asList(holidayImport));
    }

    public void saveToFile(String fileName, List<Holiday> holidays) {
        try {
            objectMapper.writer().withRootName(HOLIDAYS).writeValue(new File(fileName), holidays);
            logger.info("JSON file created!\n");
        } catch (IOException e) {
            logger.info("Error with saving Api in local file!\n", e);
        }
    }

}
