package com.infoshare.academy.highfive.vacation;

import com.infoshare.academy.highfive.consolemenu.MainMenu;
import com.infoshare.academy.highfive.employeemgmt.Employee;
import com.infoshare.academy.highfive.employeemgmt.EmployeeMgmtSingleton;
import com.infoshare.academy.highfive.tool.DateValidatorUsingLocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class VacationPlanner {


    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private DateValidatorUsingLocalDate validator = new DateValidatorUsingLocalDate(dateFormatter);
    private List<Vacation> vacationList = VacationSingleton.getInstance().getVacationList();
    private static List<Employee> employeeList = EmployeeMgmtSingleton.getInstance().getEmployeeList();

    public List<Vacation> planVacation() throws Exception {

        stdout.info("\n" + "Please follow instructions to add employee vacation \n");

        stdout.info(employeeList.toString());

        String employeeName = getEmployeeName();
//        Integer employeeId = returnEmployeeId(employeeName);
        String dateFrom = getDateFrom();
        String dateTo = getDateTo();
        dateFromPastDateToChecking(dateFrom, dateTo);
        Integer holidaysUsed = calculatingDaysAmount(creatingVacationDaysList(dateFrom, dateTo));


        //TODO create function to get holidays entitlement and then save updated entitlement

        List<Vacation> vacations = new ArrayList<>();

        List<String> testList = new LinkedList<>();

//        testList.add(String.valueOf(employeeId));
        testList.add(dateFrom);
        testList.add(dateTo);
        testList.add(String.valueOf(holidaysUsed));
        stdout.info(testList.toString());

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

    private static List<Employee> returnEmployeeId(String nameToSearch) {
        return employeeList.stream()
                .filter(l -> (l.getFirstName().toLowerCase() + " " + l.getSurname().toLowerCase()).contains(nameToSearch.toLowerCase()))
                .collect(Collectors.toList());

    }

    //TODO create function to get id from employee JSON


    void dateFromPastDateToChecking(String dateFrom, String dateTo) throws Exception {

        Date dateFromAsDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateFrom);
        Date dateToAsDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateTo);

        if (dateFromAsDate.after(dateToAsDate)) {

            stdout.info("Start date after end date, please choose correct days.");

            planVacation();
        }

    }

    List<LocalDate> creatingVacationDaysList(String dateFrom, String dateTo) {

        LocalDate start = LocalDate.parse(dateFrom);
        LocalDate end = LocalDate.parse(dateTo);
        List<LocalDate> totalDates = new LinkedList<>();
        while (!start.isAfter(end)) {
            totalDates.add(start);
            start = start.plusDays(1);
        }

    return totalDates;
    }

    Integer calculatingDaysAmount(List<LocalDate> totalDates) {

        List<LocalDate> holidays = new LinkedList<>();

        for (LocalDate day:totalDates) {
            if ("SATURDAY".equals(day.getDayOfWeek().name())) {
                holidays.add(day);
            } else if ("SUNDAY".equals(day.getDayOfWeek().name())) {
                holidays.add(day);
            }
//            else if () {
                //TODO get dates from singleton
//                holidays.add(day);
//            }
        }

        return totalDates.size() - holidays.size();
    }

}




