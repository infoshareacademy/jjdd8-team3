package com.infoshare.academy.highfive;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.Arrays;

public class Holiday {

    private String name;
    private String description;
    private HolidayDate date;

    public Holiday() {
    }

    public Holiday(String name, String description, HolidayDate date) {
        this.name = name;
        this.description = description;
        this.date = date;
    }

    @JsonAlias({"types", "type"})
    private HolidayType[] types;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HolidayDate getDate() {
        return date;
    }

    public void setDate(HolidayDate date) {
        this.date = date;
    }

    public HolidayType[] getTypes() {
        return types;
    }

    public void setTypes(HolidayType[] types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "Holidays{" +
                "name= " + name +
                ", description= " + description +
                ", date=" + date +
                ", enumType=" + Arrays.toString(types) +
                '}' + "\n";
    }

}
