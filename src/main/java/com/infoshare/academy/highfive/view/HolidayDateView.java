package com.infoshare.academy.highfive.view;


import com.infoshare.academy.highfive.ConfigurationLoader;
import com.infoshare.academy.highfive.holiday.Holiday;

import java.time.LocalDate;

public class HolidayDateView {

    private final LocalDate date;

    public HolidayDateView(Holiday holiday) {
        this.date = holiday.getDate().getDate();
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDateIso() {
        return date.format(ConfigurationLoader.getDateFormatter());
    }

    public int getDayInWeek() {
        return date.getDayOfWeek().getValue();
    }

    @Override
    public String toString() {
        return getDateIso();
    }

}