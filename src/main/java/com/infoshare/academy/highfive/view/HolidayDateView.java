package com.infoshare.academy.highfive.view;

import com.infoshare.academy.highfive.holiday.Holiday;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HolidayDateView {

    private Date date;

    public HolidayDateView(Holiday holiday) {
        this.date = holiday.getDate().getDate();
    }

    public Date getDate() {
        return date;
    }

    public String getDateIso() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    public int getDayInWeek() {
        SimpleDateFormat format = new SimpleDateFormat("u");
        return Integer.parseInt(format.format(date));
    }

    public String getDateInPattern(String datePattern) {
        SimpleDateFormat format = new SimpleDateFormat(datePattern);
        return format.format(date);
    }


    @Override
    public String toString() {
        return getDateIso();
    }

}
