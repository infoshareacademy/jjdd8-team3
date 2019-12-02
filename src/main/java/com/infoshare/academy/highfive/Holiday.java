package com.infoshare.academy.highfive;

import java.util.List;
public class Holiday {

    private String name;
    private String description;
    private HolidayDate date;
    private List<String> type = null;


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

    public List<String> getType() {
        return type;
    }

    public boolean isfree() {
        return type.contains("National holiday");
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Holidays{" +
                "name= " + name  +
                ", description= " + description  +
                ", date=" + date +
                ", type=" + type +
                ", free=" + isfree() +
                '}'+"\n";
    }
}
