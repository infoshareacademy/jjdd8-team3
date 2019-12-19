package com.infoshare.academy.highfive.vacation;

import com.infoshare.academy.highfive.consolmenu.MainMenu;
import com.infoshare.academy.highfive.employeemanager.Employee;
import com.infoshare.academy.highfive.employeemanager.EmployeeManagementSingleton;
import com.infoshare.academy.highfive.holiday.Holiday;
import com.infoshare.academy.highfive.holiday.HolidayType;
import com.infoshare.academy.highfive.holiday.HolidaysSingleton;
import com.infoshare.academy.highfive.tool.ColorsSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VacationPlanner {


    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private List<Vacation> vacationList = VacationSingleton.getInstance().getVacationList();
    private static final List<Employee> employeeList = EmployeeManagementSingleton.getInstance().getEmployeeList();
    private List<Holiday> holidaySingletonList = HolidaysSingleton.getInstance().getAllHolidays();
    private static boolean matchedToPattern = false;
    private static final String numberPattern = "[0-9]{1,2}";
    private String datePattern = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";

    public void chooseVacationType() throws Exception {

        stdout.info("\n" + "Please choose vacation type number: \n");
        stdout.info("1. Parental leave \n");
        stdout.info("2. Vacation leave  \n");
        Scanner scanner = getScanner();
        String vacationType = scanner.nextLine();
        switch (vacationType) {
            case "1":
                planParentalLeave();
                break;
            case "2":
                planVacation();
                break;
            case "0":
                startMenu();
                break;
            default:
                stdout.info("Please choose correct number or 0 to return to Main Menu");
                chooseVacationType();
                break;
        }
    }


    private void planParentalLeave() throws Exception {

        stdout.info("\n" + "Please follow instructions to add employee vacation \n");

        String type = "Partental";
        String nameToSearch = getEmployeeName();
        String employeeId = getEmployeeIdByScannerInput(nameToSearch);
        String entitlement = entitledParentalDaysOff(employeeId);
        String dateFrom = getDateFrom();
        String dateTo = getDateTo();
        List vacationDays = creatingVacationDaysList(dateFrom, dateTo);
        Integer daysOff = calculatingDaysAmount(vacationDays);
        dateFromPastDateToChecking(dateFrom, dateTo);
        checkIfEligible(daysOff, entitlement);
        addVacation(employeeId, dateFrom, dateTo, type);
        decreaseParentalEntitlement(employeeId, daysOff, entitlement);

    }

    private void planVacation() throws Exception {

        stdout.info("\n" + "Please follow instructions to add employee vacation \n");

        String type = "Vacation";
        String nameToSearch = getEmployeeName();
        String employeeId = getEmployeeIdByScannerInput(nameToSearch);
        String entitlement = entitledVacationDaysOff(employeeId);
        String dateFrom = getDateFrom();
        String dateTo = getDateTo();
        List vacationDays = creatingVacationDaysList(dateFrom, dateTo);
        Integer daysOff = calculatingDaysAmount(vacationDays);
        dateFromPastDateToChecking(dateFrom, dateTo);
        checkIfEligible(daysOff, entitlement);
        addVacation(employeeId, dateFrom, dateTo, type);
        decreaseVacationEntitlement(employeeId, daysOff, entitlement);

    }

    String entitledVacationDaysOff(String employeeId) {

        return employeeList.stream()
                .filter(e -> e.getEmployeeId().toString().equals(employeeId))
                .findFirst().get().getHolidayEntitlement().toString();
    }

    String entitledParentalDaysOff(String employeeId) {

        return employeeList.stream()
                .filter(e -> e.getEmployeeId().toString().equals(employeeId))
                .findFirst().get().getAdditionalEntitlement().toString();
    }

    void dateFromPastDateToChecking(String dateFrom, String dateTo) throws Exception {

        Date dateFromAsDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateFrom);
        Date dateToAsDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateTo);

        if (dateFromAsDate.after(dateToAsDate)) {

            stdout.info("Start date after end date, please choose correct days.");

            planVacation();
        }
    }

    void checkIfEligible(Integer daysOff, String entitlement) throws Exception {

        if (daysOff > Integer.parseInt(entitlement)) {

            stdout.info("Given days are exceeding employee's entitlement, please type correct days. Current entitlement: " + entitlement + " days.");
            planVacation();
        }
    }

    private void decreaseVacationEntitlement(String employeeId, Integer daysOff, String entitlement) throws Exception {

        employeeList.stream()
                .filter(e -> e.getEmployeeId().toString().equals(employeeId))
                .findFirst().get().setHolidayEntitlement(Integer.parseInt(entitlement) - daysOff);

        saveAllEmployeeDb();
        startMenu();

    }

    private void decreaseParentalEntitlement(String employeeId, Integer daysOff, String entitlement) throws Exception {

        employeeList.stream()
                .filter(e -> e.getEmployeeId().toString().equals(employeeId))
                .findFirst().get().setAdditionalEntitlement(Integer.parseInt(entitlement) - daysOff);

        saveAllEmployeeDb();
        startMenu();

    }

    private void addVacation(String employeeId, String dateFrom, String dateTo, String type) {


        Vacation vacation = new Vacation(employeeId, dateFrom, dateTo, type);
        vacationList.add(vacation);
        saveVacationDb();
    }

    String getEmployeeName() throws Exception {

        stdout.info("\n" + "Please type employee name or 0 to exit to Main Menu: \n");
        Scanner scanner = new Scanner(System.in);
        String nameToSearch;

        if (scanner.equals("0")) {
            startMenu();
        }

        do {
            stdout.info("Search by Full name: ");
            nameToSearch = scanner.nextLine().strip();
        } while (nameToSearch.length() == 0);
        return nameToSearch;
    }

    static String getEmployeeIdByScannerInput(String nameToSearch) throws Exception {
        String employeeId;
        Scanner scanner = getScanner();

        do {
            stdout.info("Available employees, please choose employee ID or type 0 to exit to Main Menu \n");
            employeeList.stream()
                    .filter(l -> (l.getFirstName().toLowerCase() + " " + l.getSurname().toLowerCase()).contains(nameToSearch.toLowerCase()))
                    .forEach(employee -> stdout.info("Employee ID: " + employee.getEmployeeId() + " | Employee first name " + employee.getFirstName() + " | Employee second name:  " + employee.getSurname() + " | " + employee.getTeamName() + "\n"));

            employeeId = scanner.nextLine();

            if (employeeId.equals("0")) {
                startMenu();
            }

            matchedToPattern = employeeId.matches(numberPattern);
            if (employeeId.matches(numberPattern) && (Integer.parseInt(employeeId) < employeeList.size()+1)) {
                matchedToPattern = true;
            } else {
                stdout.info(ColorsSet.ANSI_RED + "Wrong No., please try again!\n" + ColorsSet.ANSI_RESET);
                matchedToPattern = false;
            }

        } while (!matchedToPattern);

        return employeeId;

    }

    String getDateFrom() {

        Scanner scanner = new Scanner(System.in);
        String hireDateTemp;
        boolean matchedToDatePattern = false;
        do {
            stdout.info("\n" + "Please type vacation start date in format YYYY-MM-DD: \n");
            hireDateTemp = scanner.nextLine();
            if (hireDateTemp.matches(datePattern)) {
                matchedToDatePattern = true;
            } else {
                stdout.info("Please type correct date.");
            }
        } while (!matchedToDatePattern);
        LocalDate dateFrom = LocalDate.parse(hireDateTemp, DateTimeFormatter.ofPattern("yyyy-MM-dd").withResolverStyle(ResolverStyle.SMART));

        LocalDate localDate = LocalDate.now();

        if (localDate.isAfter(dateFrom)) {
            stdout.info("Wrong input - try again\n");
            getDateFrom();
        }
        return dateFrom.format(DateTimeFormatter.ISO_DATE);
    }

    String getDateTo() {
        stdout.info("\n" + "Please type vacation end date in format YYYY-MM-DD: \n");

        Scanner scanner = new Scanner(System.in);
        String dateTo = scanner.nextLine();

        if (dateTo.matches(datePattern)) {
            return dateTo;
        } else {
            stdout.info("Wrong input - try again\n");
            getDateTo();
        }

        return dateTo;

    }

    static Scanner getScanner() {

        return new Scanner(System.in);
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

        List<Holiday> publicHolidayList = holidaySingletonList.stream().filter(h -> Array.get(h.getTypes(), 0).equals(HolidayType.NATIONAL_HOLIDAY))
                .collect(Collectors.toList());

        for (LocalDate day : totalDates) {
            if ("SATURDAY".equals(day.getDayOfWeek().name())) {
                holidays.add(day);
            } else if ("SUNDAY".equals(day.getDayOfWeek().name())) {
                holidays.add(day);
            } else if (publicHolidayList.contains(day)) {

                holidays.add(day);
            }
        }

        return totalDates.size() - holidays.size();
    }


    static void saveVacationDb() {
        VacationSingleton.getInstance().saveVacationsDb("Vacation.json");

    }

    static void saveAllEmployeeDb() {
        EmployeeManagementSingleton.getInstance().saveEmployeesDb("employee_fdb.json");
    }

    static void startMenu() throws Exception {
        MainMenu mainMenu = new MainMenu();
        mainMenu.menuOptionsDisplay();
        mainMenu.getUserChoice();

    }
}




