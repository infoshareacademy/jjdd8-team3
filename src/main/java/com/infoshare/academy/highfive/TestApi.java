package com.infoshare.academy.highfive;

import java.io.IOException;
import java.util.ArrayList;

public class TestApi {

    public static void main(String[] args) throws Exception {

        //HolidaysSingleton.getInstance().initFromFile("abc.json");
        HolidaysSingleton.getInstance().initFromURL("https://calendarific.com/api/v2/holidays?&api_key=c2ddb57bb630fc01911bbcd01ae5907afaaced8e058cc0f33a938f517c0321e3&country=PL&year=2019");

        HolidaysSingleton.getInstance().initSaveToFile("user.json");

        //ApiJsonParser.parseFromFile("user.json");
       // ApiJsonParser.showImport();
        //HolidaysSingeltone.getInstance().getArray();

        for(int i = 0; i< HolidaysSingleton.getInstance().getHolidays().size(); i++){
            System.out.println(HolidaysSingleton.getInstance().getHolidays().get(i).toString());
        }
    }

}
