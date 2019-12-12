package com.infoshare.academy.highfive.holiday;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HolidayDate {

    @JsonAlias({"date", "iso"})
    @JsonIgnoreProperties(value = {"date"})
    private Date date;

    public String getIso() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getYear() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        return Integer.parseInt(format.format(date));
    }

    public Integer getMonth() {
        SimpleDateFormat format = new SimpleDateFormat("MM");
        return Integer.parseInt(format.format(date));
    }

    public Integer getDay() {
        SimpleDateFormat format = new SimpleDateFormat("dd");
        return Integer.parseInt(format.format(date));
    }

    public Integer getDayInYear() {
        SimpleDateFormat format = new SimpleDateFormat("DD");
        return Integer.parseInt(format.format(date));
    }

    public String getDateInPattern(String datePattern) {
        SimpleDateFormat format = new SimpleDateFormat(datePattern);
        return format.format(date);
    }

    @Override
    public String toString() {
        return "HolidayDate: " +
                " #date=" + getDateInPattern("yyyy-MM-dd") +
                ", #dateInt=" + getDay() + " " + getMonth() + " " + getYear() +
                " \n";
    }

}
