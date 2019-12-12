package com.infoshare.academy.highfive;

import com.infoshare.academy.highfive.employeemgmt.EmployeeMgmtSingleton;
import com.infoshare.academy.highfive.holiday.HolidaysFilter;
import com.infoshare.academy.highfive.holiday.HolidaysSingleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.ParseException;

public class TestRuns {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String checker = System.getProperty("os.name").toLowerCase();
    public static void cleanConsole() {
        try {
            if (checker.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                stdout.info("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        HolidaysSingleton.getInstance().initFromFile("Holidays.json");
        EmployeeMgmtSingleton.getInstance().initFromFile("employee.json");
        //HolidaysSingleton.getInstance().initFromURL("https://calendarific.com/api/v2/holidays?&api_key=c2ddb57bb630fc01911bbcd01ae5907afaaced8e058cc0f33a938f517c0321e3&country=PL&year=2019");
        //HolidaysSingleton.getInstance().initSaveToFile("qqq/zzzzzz2019.json");
        cleanConsole();
        HolidaysFilter.searchByName();
        HolidaysFilter.searchByDate();
    }
}
