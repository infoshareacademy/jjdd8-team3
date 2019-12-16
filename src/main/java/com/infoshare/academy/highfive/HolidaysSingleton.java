package com.infoshare.academy.highfive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HolidaysSingleton {

    private ApiJsonParser apiJsonParser;

    private static HolidaysSingleton instance;
    private List<Holiday> holidaysList;

    private HolidaysSingleton() {
        apiJsonParser = new ApiJsonParser();
    }

    public static synchronized HolidaysSingleton getInstance() {
        if (instance == null) {
            instance = new HolidaysSingleton();
        }
        return instance;
    }

    private void validateHolidays() {
        if (holidaysList == null) {
            throw new InitException();
        }
    }

    public List<Holiday> getAllHolidays() {
        validateHolidays();
        return this.holidaysList;
    }

    public List<Holiday>  getHolidaysFilteredByName(String filter) {
        validateHolidays();
        List<Holiday> filteredByName = new ArrayList<>();
        for (Holiday holiday : holidaysList) {
            if (holiday.getName().toLowerCase().contains(filter)) {
                filteredByName.add(holiday);
            }
        }
        return filteredByName;
    }

    public List<Holiday> getHolidaysFilteredByDate(String filter) {
        validateHolidays();
        List<Holiday> filteredByDate = new ArrayList<>();
        for (Holiday holiday : holidaysList) {
            if (holiday.getDate().getDateInPattern(ConfiguartionLoader.getDateFormat()).contains(filter)) {
                filteredByDate.add(holiday);
            }
        }
        return filteredByDate;
    }

    public void initFromFile(String fileName) throws IOException {
        holidaysList = apiJsonParser.parseFromFile(fileName);
    }

    public void initFromURL(String urlPath) throws IOException {
        holidaysList = apiJsonParser.parseFromURL(urlPath);
    }

    public void initSaveToFile(String filename) {
        apiJsonParser.saveToFile(filename, holidaysList);
    }

}
