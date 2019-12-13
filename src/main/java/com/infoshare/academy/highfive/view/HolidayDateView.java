package com.infoshare.academy.highfive.view;

import com.infoshare.academy.highfive.holiday.Holiday;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HolidayDateView {

    private LocalDate date;

    public HolidayDateView(Holiday holiday) {
        this.date = holiday.getDate().getDate();
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDateIso() {
        return date.format(DateTimeFormatter.ISO_DATE);
    }

    public int getDayInWeek() {
        return date.getDayOfWeek().getValue();
    }

    @Override
    public String toString() {
        return getDateIso();
    }

}
