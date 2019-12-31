package com.infoshare.academy.highfive.vacation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.infoshare.academy.highfive.tool.ColorsSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class VacationJsonParser {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String VACATION = "vacations";
    private ObjectMapper objectMapper;

    VacationJsonParser() {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
    }

    List<Vacation> parseFromFile(String fileName) throws IOException {
        return parseJson(objectMapper.readTree(new File(fileName)));
    }

    private List<Vacation> parseJson(JsonNode jsonNodeBase) {
        Vacation[] vacationImport = {};
        try {
            JsonNode jsonData = jsonNodeBase.findPath(VACATION);
            vacationImport = objectMapper.treeToValue(jsonData, Vacation[].class);
            stdout.info(ColorsSet.ANSI_CYAN + "\nVacation from JSON imported!\nDatabase ready to use!" + ColorsSet.ANSI_RESET);
        } catch (JsonProcessingException e) {
            stdout.info("There is a little problem with JSON Import!\n", e);
        }
        return new ArrayList<>(Arrays.asList(vacationImport));
    }

    void saveToFile(String fileName, List<Vacation> vacations) {
        try {
            objectMapper.writer().withRootName(VACATION).writeValue(new File(fileName), vacations);
            stdout.info("JSON file created!\n");
        } catch (IOException e) {
            stdout.info("There is a little problem with file Saving!\n", e);
        }
    }

    void saveVacationDb(String fileName, Map<String, Object> vacationDb) {
        try {
            objectMapper.writer().withRootName("Vacation.json").writeValue(new File(fileName), vacationDb);
            stdout.info("Vacation Database Saved!\n");
        } catch (IOException e) {
            stdout.info("There is a little problem with file Saving Employees DB!\n", e);
        }
    }
}