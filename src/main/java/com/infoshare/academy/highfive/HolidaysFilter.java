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

public class HolidaysFilter {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static String searchByName() {

        String inputTxt;
        Scanner scanner = new Scanner(System.in);

        do {
            stdout.info("Type Holiday Name(min. 3 char.) or type [0] to exit: ");
            inputTxt = scanner.nextLine().strip();

            if (inputTxt.length() == 1 && inputTxt.equals("0")) {
                break;
            }

        } while (inputTxt.length() < 3);

        stdout.info("You typed: " + inputTxt + "\n");

        queryResults(inputTxt.toLowerCase(), "byName");

        stdout.info("Type [1] to search again or something else to exit: ");

        inputTxt = scanner.nextLine();

        if (inputTxt.length() == 1 && inputTxt.equals("1")) {
            searchByName();
        }

        return inputTxt;
    }

    public static String searchByDate() throws ParseException {

        String datePattern = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
        boolean matchedToDatePattern;
        String inputTxt;
        Scanner scanner;

        do {
            stdout.info("Type Date in format yyyy-mm-dd or type [0] to exit: ");
            scanner = new Scanner(System.in);
            matchedToDatePattern = scanner.hasNext(datePattern);
            inputTxt = scanner.nextLine();
            if (inputTxt.length() == 1 && inputTxt.equals("0")) {
                matchedToDatePattern = false;
                break;
            }

        } while (!matchedToDatePattern);

        stdout.info("You typed: " + inputTxt + "\n");

        if (matchedToDatePattern) {
            stdout.info("It's: " + new SimpleDateFormat("EEEE").format(new SimpleDateFormat("yyyy-MM-dd").parse(inputTxt)) + "\n");
            queryResults(inputTxt, "byDate");

            stdout.info("Type [1] to search again or something else to exit: ");

            inputTxt = scanner.nextLine();

            if (inputTxt.length() == 1 && inputTxt.equals("1")) {
                searchByDate();
            }
        }

        return inputTxt;
    }

    public static void queryResults(String filter, String filterType) {

        List<Holiday> resultHolidayList;

        if (filterType.equals("byDate")) {
            resultHolidayList = HolidaysSingleton.getInstance().getHolidaysFilteredByDate(filter);
        } else if (filterType.equals("byName")) {
            resultHolidayList = HolidaysSingleton.getInstance().getHolidaysFilteredByName(filter);
        } else {
            stdout.info("Operation not supported!!");
            return;
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
        if (viewList.size() > 0) {
            stdout.info("______\n" + viewList.size() + " result(s) found for this query!\n------\n");
        } else {
            stdout.info("______\nNo result(s) found for this query!\n------\n");
        }

    }

}
