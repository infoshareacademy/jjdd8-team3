package com.infoshare.academy.highfive;

import java.io.IOException;
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

    public List<Holiday> getHolidays() throws Exception {
        if(holidayArrayList == null) {
            throw new InitException();
        } else {
            return this.holidayArrayList;
        }
    }

    public void initFromFile(String fileName) throws IOException {
        holidayArrayList = ApiJsonParser.parseFromFile(fileName);
    }

    public void initFromURL(String urlPath) throws IOException {
        holidayArrayList = ApiJsonParser.parseFromURL(urlPath);
    }

    public void initSaveToFile(String filename) throws Exception {
       ApiJsonParser.saveToFile(filename,holidayArrayList);
    }
}