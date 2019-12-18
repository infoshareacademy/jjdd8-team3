package com.infoshare.academy.highfive.view;

import com.infoshare.academy.highfive.holiday.HolidayType;

public class HolidayView {

    private final String name;
    private final String description;
    private final HolidayDateView date;
    private final HolidayType[] types;

    public HolidayView(String name, String description, HolidayDateView date, HolidayType[] types) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.types = types;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public HolidayType getTypes() {
        return types[0];
    }

    public HolidayDateView getDate() {
        return date;
    }

    @Override
    public String toString() {
        return date + " | "
                + date.getDate().getDayOfWeek()
                + " | Type " + types[0].getType()
                + ", Name Of Holiday: " + name + " - " + description + "\n";
    }

}
