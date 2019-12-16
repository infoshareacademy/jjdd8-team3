package com.infoshare.academy.highfive.tool;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ParseStringToIsoDate {

    private ParseStringToIsoDate() {
        throw new IllegalStateException("Utility parse ISO date class");
    }

    public static LocalDate parseStringToDate(String dateString) {
        return LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE);
    }
}
