package com.infoshare.academy.highfive.domain.view;

import com.infoshare.academy.highfive.domain.HolidayType;

import java.time.LocalDate;

public class HolidayView {

    private Long id;

    private String name;

    private String description;

    private LocalDate date;

    private HolidayType holidayType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public HolidayType getHolidayType() {
        return holidayType;
    }

    public void setHolidayType(HolidayType holidayType) {
        this.holidayType = holidayType;
    }
}
