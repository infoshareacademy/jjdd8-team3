package com.infoshare.academy.highfive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HolidaysSingleton {

    private static HolidaysSingleton instance;
    private List<Holiday> holidayArrayList;

    private HolidaysSingleton() {
    }

    public static synchronized HolidaysSingleton getInstance() {
        if (instance == null) {
            instance = new HolidaysSingleton();
        }
        return instance;
    }

    private void validateHolidays() {
        if (holidayArrayList == null) {
            throw new InitException();
        }
    }

    public List<Holiday> getAllHolidays() {
        validateHolidays();
        return this.holidayArrayList;
    }

    public List<Holiday>  getHolidaysFilteredByName(String filter) {
        validateHolidays();
        List<Holiday> filteredByName = new ArrayList<>();
        for (Holiday holiday : holidayArrayList) {
            if (holiday.getName().toLowerCase().contains(filter)) {
                filteredByName.add(holiday);
            }
        }
        return filteredByName;
    }

    public List<Holiday> getHolidaysFilteredByDate(String filter) {
        validateHolidays();
        List<Holiday> filteredByDate = new ArrayList<>();
        for (Holiday holiday : holidayArrayList) {
            if (holiday.getDate().getDateInPattern("yyyy-MM-dd").contains(filter)) {
                filteredByDate.add(holiday);
            }
        }
        return filteredByDate;
    }

    public void initFromFile(String fileName) throws IOException {
        holidayArrayList = ApiJsonParser.parseFromFile(fileName);
    }

    public void initFromURL(String urlPath) throws IOException {
        holidayArrayList = ApiJsonParser.parseFromURL(urlPath);
    }

    public void initSaveToFile(String filename) throws Exception {
        ApiJsonParser.saveToFile(filename, holidayArrayList);
    }

}
