package com.infoshare.academy.highfive.vacation;

import com.infoshare.academy.highfive.consolemenu.MainMenu;
import com.infoshare.academy.highfive.tool.DateValidatorUsingLocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VacationPlanner {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private DateValidatorUsingLocalDate validator = new DateValidatorUsingLocalDate(dateFormatter);

    public List<Vacation> planVacation() throws Exception {

        String employeeName = getEmployeeName();
        int employeeId = returnEmployeeId(employeeName);
        String dateFrom = getDateFrom();
        String dateTo = getDateTo();
        dateFromPastDateToChecking(dateFrom, dateTo);
        int holidaysUsed = calculatingDaysAmount(creatingVacationDaysList(dateFrom, dateTo));

        //TODO create function to get holidays entitlement and then save updated entitlement

        List<Vacation> vacations = new ArrayList<>();

//        vacations.add(employeeId);
//        vacations.add(dateFrom);
//        vacations.add(dateTo);

        //TODO add save to vacation list and then save to file

        return vacations;
    }


    String getEmployeeName() throws Exception {

        stdout.info("\n" + "Please type employee name or X to exit to Main Menu: \n");

        Scanner scanner = new Scanner(System.in);
        String employee = scanner.nextLine();
        if (employee.equals("X")) {
            MainMenu mainMenu = new MainMenu();
            mainMenu.menuOptionsDisplay();
            mainMenu.getUserChoice();
        } else {
            nameMatchToPattern(employee);
        }
        return employee;

        }

    String getDateFrom() {
        stdout.info("\n" + "Please type vacation start date in format YYYY-MM-DD: \n");

        Scanner scanner = new Scanner(System.in);
        String dateFrom = scanner.nextLine();

        if (validator.isValid(dateFrom)) {
            return dateFrom;
        } else {stdout.info("Wrong input - try again\n");
            getDateTo();
        }
        return dateFrom;
    }

    String getDateTo() {
        stdout.info("\n" + "Please type vacation end date in format YYYY-MM-DD: \n");

        Scanner scanner = new Scanner(System.in);
        String dateTo = scanner.nextLine();

        if (validator.isValid(dateTo)) {
            return dateTo;
        } else {stdout.info("Wrong input - try again\n");
                getDateTo();
        }

        return dateTo;

    }
    private void nameMatchToPattern(String employee) throws Exception {
        String regexName = "\\p{Upper}(\\p{Lower}+\\s?)";
        String patternName = "(" + regexName + "){2,3}";
        boolean matchedToPattern = employee.matches(patternName);

        if (!matchedToPattern) {
            stdout.info("Wrong input - try again\n");
            getEmployeeName();
        }

    }

    int returnEmployeeId(String employeeName) {

        int employeeID = 1;

        //TODO create function to get id from employee JSON

        return employeeID;

    }

    void dateFromPastDateToChecking(String dateFrom, String dateTo) throws Exception {

        Date dateFromAsDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateFrom);
        Date dateToAsDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateTo);

        if (dateFromAsDate.after(dateToAsDate)) {

            stdout.info("Start date after end date, please choose correct days.");

            planVacation();
        }

    }

    Date[] datesParser(String dateFrom, String dateTo) throws ParseException {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDateFrom =  df.parse(dateFrom);
        Date parsedDateTo =  df.parse(dateTo);

        return new Date[] {parsedDateFrom, parsedDateTo};
    }

    List<LocalDate> creatingVacationDaysList(String dateFrom, String dateTo) {
//        long vacationDays = dates[0].getTime() - dates[1].getTime();

        LocalDate start = LocalDate.parse(dateFrom);
        LocalDate end = LocalDate.parse(dateTo);
        List<LocalDate> totalDates = new ArrayList<>();
        while (!start.isAfter(end)) {
            totalDates.add(start);
            start = start.plusDays(1);
        }

    return totalDates;
    }

    int calculatingDaysAmount(List<LocalDate> totalDates) {

        for (LocalDate day:totalDates) {
            if ("Saturday".equals(day.getDayOfWeek().name())) {
                totalDates.remove(day);
            } else if ("Sunday".equals(day.getDayOfWeek().name())) {
                totalDates.remove(day);
//            } else if ()
            //TODO get dates from singleton
        }

        }

        return totalDates.size();
    }

}




