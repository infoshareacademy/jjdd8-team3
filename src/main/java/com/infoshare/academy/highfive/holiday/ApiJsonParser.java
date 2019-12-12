package com.infoshare.academy.highfive.holiday;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.infoshare.academy.highfive.employeemgmt.Employee;
import com.infoshare.academy.highfive.tool.ColorsSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApiJsonParser {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String HOLIDAYS = "holidays";
    private ObjectMapper objectMapper;

    public ApiJsonParser() {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
    }

    public List<Holiday> parseFromFile(String fileName) throws IOException {
        return parseJson(objectMapper.readTree(new File(fileName)));
    }

    public List<Holiday> parseFromURL(String urlPath) throws IOException {
        return parseJson(objectMapper.readTree(new URL(urlPath)));
    }

    private List<Holiday> parseJson(JsonNode jsonNodeBase) {
        Holiday[] holidayImport = {};
        try {
            JsonNode jsonData = jsonNodeBase.findPath(HOLIDAYS);
            holidayImport = objectMapper.treeToValue(jsonData, Holiday[].class);
            stdout.info(ColorsSet.ANSI_CYAN  + "\nHolidays from JSON imported!\nDatabase ready to use!" + ColorsSet.ANSI_RESET + "\n");
        } catch (JsonProcessingException e) {
            stdout.info("There is a little problem with JSON Import!\n", e);
        }
        return new ArrayList<>(Arrays.asList(holidayImport));
    }

    public void saveToFile(String fileName, List<Holiday> holidays) {
        try {
            objectMapper.writer().withRootName(HOLIDAYS).writeValue(new File(fileName), holidays);
            stdout.info("JSON file created!\n");
        } catch (IOException e) {
            stdout.info("There is a little problem with file Saving!\n", e);
        }
    }

}
