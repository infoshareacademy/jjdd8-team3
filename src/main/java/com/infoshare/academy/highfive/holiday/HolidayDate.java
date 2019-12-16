package com.infoshare.academy.highfive.holiday;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.infoshare.academy.highfive.tool.CustomHolidayDateDeserializer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@JsonDeserialize(using = CustomHolidayDateDeserializer.class)
public class HolidayDate {

    private LocalDate date;

    public HolidayDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getIso() {
        return date.format(DateTimeFormatter.ISO_DATE);
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDateInPattern(String datePattern) {
        return date.format(DateTimeFormatter.ofPattern(datePattern));
    }

    @Override
    public String toString() {
        return "HolidayDate: " +
                " #date=" + getDateInPattern("yyyy-MM-dd") +
                " \n";
    }

}
