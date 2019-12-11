package com.infoshare.academy.highfive.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParseStringToIsoDate {

    public static Date parseStringToDate(String dateString) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(dateString);
    }
}
