package com.infoshare.academy.highfive;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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

    public static List<Holiday> parseFromFile(String fileName) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode jsonNode = objectMapper.readTree(new File(fileName));
        JsonNode jsonData = jsonNode.findPath("holidays");
        Holiday[] holidayImport = objectMapper.treeToValue(jsonData, Holiday[].class);
        stdout.info("JSON imported!");
        return new ArrayList<>(Arrays.asList(holidayImport));
    }

    public static List<Holiday> parseFromURL(String urlPath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode jsonNode = objectMapper.readTree(new URL(urlPath));
        JsonNode jsonData = jsonNode.findPath("holidays");
        Holiday[] holidayImport = objectMapper.treeToValue(jsonData, Holiday[].class);
        stdout.info("JSON imported!");
        return new ArrayList<>(Arrays.asList(holidayImport));
    }

    public static void saveToFile(String fileName, List<Holiday> holidays) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
        objectMapper.writer().withRootName("holidays").writeValue(new File(fileName), holidays);
        stdout.info("JSON file created!");
    }

}
