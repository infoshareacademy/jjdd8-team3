package com.infoshare.academy.highfive.vacation;

import com.infoshare.academy.highfive.consolemenu.MainMenu;
import com.infoshare.academy.highfive.employeemgmt.Employee;
import com.infoshare.academy.highfive.holiday.Holiday;
import com.infoshare.academy.highfive.holiday.HolidaysSingleton;
import com.infoshare.academy.highfive.mapper.EmployeeManagementSingleton;
import com.infoshare.academy.highfive.tool.ColorsSet;
import com.infoshare.academy.highfive.tool.DateValidatorUsingLocalDate;
import com.infoshare.academy.highfive.tool.TerminalCleaner;
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
    private static final List<Employee> employeeList = EmployeeManagementSingleton.getInstance().getEmployeeList();
    private List<Holiday> holidayList = HolidaysSingleton.getInstance().getAllHolidays();
    private static boolean matchedToPattern = false;
    private static final String numberPattern = "[0-9]{1,2}";

    public List<Vacation> planVacation() throws Exception {

        stdout.info("\n" + "Please follow instructions to add employee vacation \n");

        String[] employeeName = getEmployeeName();
        String firstName = employeeName[0];
        String secondName =employeeName[1];
        String employeeId = getEmployeeIdByScannerInput(firstName, secondName); //FIXME not working getemployeeid
        String dateFrom = getDateFrom();
        String dateTo = getDateTo();
        dateFromPastDateToChecking(dateFrom, dateTo);
        Integer holidaysUsed = calculatingDaysAmount(creatingVacationDaysList(dateFrom, dateTo));
        addVacation(employeeId, dateFrom,dateTo);

        return null;
    }

    protected void decreaseVacationEntitlement(String employeeId) {



        //TODO create function to get holidays entitlement and then save updated entitlement

    }

    protected void addVacation(String employeeId, String dateFrom, String dateTo ) {


        Vacation vacation = new Vacation(employeeId, dateFrom, dateTo);
        vacationList.add(vacation);
        saveVacationDb();

    }

    protected String[] getEmployeeName() throws Exception {

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
        String[] employeeTable = employee.split(" ");

        return employeeTable;

        }

    protected static String getEmployeeIdByScannerInput(String firstName, String secondName) {
        String employeeId;
        Scanner scanner = getScanner();

        do {
            stdout.info("Available employees >>>\n");
            employeeList.stream()
                    .filter(employee -> employee.getFirstName().equals(firstName))
                    .filter(employee -> employee.getSurname().equals(secondName))
                    .forEach(employee -> stdout.info(employee.getEmployeeId() + " " + employee.getFirstName()+ " " + employee.getSurname()));
            stdout.info("\n<<<\nSelect employee: ");
            employeeId = scanner.nextLine();
            matchedToPattern = employeeId.matches(numberPattern);
            if (employeeId.matches(numberPattern) && (Integer.parseInt(employeeId) < employeeList.size())) {
                matchedToPattern = true;
            } else {
                stdout.info(ColorsSet.ANSI_RED + "Wrong No., please try again!\n" + ColorsSet.ANSI_RESET);
                matchedToPattern = false;
            }

        } while (!matchedToPattern);

        return employeeId;

    }

    protected String getDateFrom() {
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

    protected String getDateTo() {
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


    protected void dateFromPastDateToChecking(String dateFrom, String dateTo) throws Exception {

        Date dateFromAsDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateFrom);
        Date dateToAsDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateTo);

        if (dateFromAsDate.after(dateToAsDate)) {

            stdout.info("Start date after end date, please choose correct days.");

            planVacation();
        }

    }

    protected List<LocalDate> creatingVacationDaysList(String dateFrom, String dateTo) {

        LocalDate start = LocalDate.parse(dateFrom);
        LocalDate end = LocalDate.parse(dateTo);
        List<LocalDate> totalDates = new LinkedList<>();
        while (!start.isAfter(end)) {
            totalDates.add(start);
            start = start.plusDays(1);
        }

    return totalDates;
    }

    protected Integer calculatingDaysAmount(List<LocalDate> totalDates) {

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

    //TODO from employee mgmt


    private static List<Employee> findEmployeeByFullName(String nameToSearch) {
        return employeeList.stream()
                .filter(l -> (l.getFirstName().toLowerCase() + " " + l.getSurname().toLowerCase()).contains(nameToSearch.toLowerCase()))
                .collect(Collectors.toList());
    }

    static Scanner getScanner() {
        TerminalCleaner.cleanTerminal();
        return new Scanner(System.in);
    }

    protected static void saveVacationDb() {
        VacationSingleton.getInstance().initSaveToFile("Vacation.json");

        //FIXME overwriting file
    }


    protected static String getEmployeeIndexByScannerInput(Scanner scanner, List<Employee> employeeListToAction) {
        String employeeIdx;
        do {
            stdout.info("Enter Employee No.: ");
            employeeIdx = scanner.nextLine();
            if (employeeIdx.matches(numberPattern) && (Integer.parseInt(employeeIdx) < employeeListToAction.size())) {
                matchedToPattern = true;
            } else {
                stdout.info(ColorsSet.ANSI_RED + "Wrong No., please try again!\n" + ColorsSet.ANSI_RESET);
                matchedToPattern = false;
            }
        } while (!matchedToPattern);
        return employeeIdx;
    }

    static List<Employee> selectEmployeeByFullName(Scanner scanner) {
        String nameToSearch;
        do {
            stdout.info("Search by Full name: ");
            nameToSearch = scanner.nextLine().strip();
        } while (nameToSearch.length() == 0);

        List<Employee> employeeListToAction = findEmployeeByFullName(nameToSearch);
        employeeListToAction.forEach(l -> stdout.info("No " + employeeListToAction.indexOf(l) + ". " + l.getFirstName() + " " + l.getSurname() + " " + l.getTeamName().getTeamName() + "\n"));
        return employeeListToAction;
    }

}




