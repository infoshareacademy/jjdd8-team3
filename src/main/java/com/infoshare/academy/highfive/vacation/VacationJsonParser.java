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
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class VacationJsonParser {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String VACATION = "Vacation";
    private ObjectMapper objectMapper;

    public VacationJsonParser() {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
    }

    public List<Vacation> parseFromFile(String fileName) throws IOException {
        return parseJson(objectMapper.readTree(new File(fileName)));
    }

    private List<Vacation> parseJson(JsonNode jsonNodeBase) {
        Vacation[] vacationImport = {};
        try {
            JsonNode jsonData = jsonNodeBase.findPath("vacations");
            vacationImport = objectMapper.treeToValue(jsonData, Vacation[].class);
            stdout.info(ColorsSet.ANSI_CYAN + "\nVacation from JSON imported!\nDatabase ready to use!" + ColorsSet.ANSI_RESET + "\n");
        } catch (JsonProcessingException e) {
            stdout.info("There is a little problem with JSON Import!\n", e);
        }
        return new ArrayList<>(Arrays.asList(vacationImport));
    }

    public void saveToFile(String fileName, List<Vacation> vacations) {
        try {
            objectMapper.writer().withRootName(VACATION).writeValue(new File(fileName), vacations);
            stdout.info("JSON file created!\n");
        } catch (IOException e) {
            stdout.info("There is a little problem with file Saving!\n", e);
        }
    }

       public void saveVacationDb(String fileName, Map<String, Object> vacationDb) {
            try {
                objectMapper.writer().withRootName("Vacation.json").writeValue(new File(fileName), vacationDb);
                stdout.info("Saved!\n");
            } catch (IOException e) {
                stdout.info("There is a little problem with file Saving Employees DB!\n", e);
            }
    }
}