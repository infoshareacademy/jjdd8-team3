package com.infoshare.academy.highfive.holiday;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.infoshare.academy.highfive.employeemgmt.Employee;
import com.infoshare.academy.highfive.employeemgmt.Team;
import com.infoshare.academy.highfive.tool.ColorsSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApiJsonParser {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String HOLIDAYS = "holidays";
    private final String employees = "employees";
    private ObjectMapper objectMapper;

    public ApiJsonParser() {
        objectMapper = new ObjectMapper();
        JavaTimeModule module = new JavaTimeModule();
        LocalDateTimeDeserializer localDateTimeDeserializer = new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        module.addDeserializer(LocalDateTime.class, localDateTimeDeserializer);
        objectMapper.registerModule(module);
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
            stdout.info(ColorsSet.ANSI_CYAN + "\nHolidays from JSON imported!\nDatabase ready to use!" + ColorsSet.ANSI_RESET + "\n");
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

    public void saveToFileTeam(String fileName, List<Team> teamsList) {
        try {
            objectMapper.writer().withRootName("teams").writeValue(new File(fileName), teamsList);
            stdout.info("Saved!\n");
        } catch (IOException e) {
            stdout.info("There is a little problem with file Saving!\n", e);
        }
    }

    public void saveToFileEmployee(String fileName, List<Employee> employeeList) {
        try {
            objectMapper.writer().withRootName(employees).writeValue(new File(fileName), employeeList);
            stdout.info("Saved!\n");
        } catch (IOException e) {
            stdout.info("There is a little problem with file Saving!\n", e);
        }
    }

    public List<Team> parseTeamFile(String fileName) throws IOException {
        return parseTeam(objectMapper.readTree(new File(fileName)));
    }

    private List<Team> parseTeam(JsonNode jsonNodeBase) {
        Team[] teamImport = {};
        try {
            JsonNode jsonData = jsonNodeBase.findPath("teams");
            teamImport = objectMapper.treeToValue(jsonData, Team[].class);
            stdout.info(ColorsSet.ANSI_CYAN + "\nTeams from JSON imported!\nDatabase ready to use!" + ColorsSet.ANSI_RESET + "\n");
        } catch (JsonProcessingException e) {
            stdout.info("There is a little problem with JSON Import!\n", e);
        }
        return new ArrayList<>(Arrays.asList(teamImport));
    }

    public List<Employee> parseEmployeeFile(String fileName) throws IOException {
        return parseEmployee(objectMapper.readTree(new File(fileName)));
    }

    private List<Employee> parseEmployee(JsonNode jsonNodeBase) {
        Employee[] employeeImport = {};
        try {
            JsonNode jsonData = jsonNodeBase.findPath("employees");
            employeeImport = objectMapper.treeToValue(jsonData, Employee[].class);
            stdout.info(ColorsSet.ANSI_CYAN + "\nEmployees from JSON imported!\nDatabase ready to use!" + ColorsSet.ANSI_RESET + "\n");
        } catch (JsonProcessingException e) {
            stdout.info("There is a little problem with JSON Import!\n", e);
        }
        return new ArrayList<>(Arrays.asList(employeeImport));
    }

}
