package com.infoshare.academy.highfive;

import com.infoshare.academy.highfive.view.HolidayDateView;
import com.infoshare.academy.highfive.view.HolidayView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilterHolidays {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static String searchByName() {

        String inputTxt;
        Scanner scanner = new Scanner(System.in);

        do {
            stdout.info("Enter Holiday Name(min. 3 char.): ");
            inputTxt = scanner.nextLine().strip();

        } while (inputTxt.length() < 3);

        stdout.info("You entered: " + inputTxt + "\n");

        queryResults(inputTxt.toLowerCase(), "byName");

        return inputTxt;
    }

    public static String searchByDate() throws ParseException {

        String datePattern = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
        boolean matchPattern;
        String inputTxt;
        Scanner scanner;

        do {
            stdout.info("Enter Date yyyy-mm-dd: ");
            scanner = new Scanner(System.in);
            matchPattern = scanner.hasNext(datePattern);

        } while (!matchPattern);

        inputTxt = scanner.nextLine();

        stdout.info("You entered: " + inputTxt + "\n");
        stdout.info("It's: " + new SimpleDateFormat("EEEE").format(new SimpleDateFormat("yyyy-MM-dd").parse(inputTxt)) + "\n");

        queryResults(inputTxt, "byDate");

        return inputTxt;
    }

    public static void queryResults(String filter, String filterType) {

        List<Holiday> resultHolidayList = null;

        if (filterType.equals("byDate")) {
            resultHolidayList = HolidaysSingleton.getInstance().getHolidaysFilteredByDate(filter);
        } else if (filterType.equals("byName")) {
            resultHolidayList = HolidaysSingleton.getInstance().getHolidaysFilteredByName(filter);
        } else {
            stdout.info("Operation not supported!!");
        }

        List<HolidayView> viewList = new ArrayList<>();

        for (Holiday holiday : resultHolidayList) {
            HolidayView holidayView = new HolidayView(holiday.getName(), holiday.getDescription(), new HolidayDateView(holiday), holiday.getTypes());

            if (holidayView.getDate().getDayInWeek() == 6 && holidayView.getTypes().equals(HolidayType.NATIONAL_HOLIDAY)) {
                stdout.info("For this day you will be able to take extra holiday!\n");
            }

            stdout.info(holidayView.toString());

            viewList.add(holidayView);
        }

    }

}
