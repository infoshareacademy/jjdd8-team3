package com.infoshare.academy.highfive.vacation;

import com.infoshare.academy.highfive.consolmenu.MainMenu;
import com.infoshare.academy.highfive.employeemanager.Employee;
import com.infoshare.academy.highfive.employeemanager.EmployeeManagementSingleton;
import com.infoshare.academy.highfive.holiday.Holiday;
import com.infoshare.academy.highfive.holiday.HolidayDate;
import com.infoshare.academy.highfive.holiday.HolidayType;
import com.infoshare.academy.highfive.holiday.HolidaysSingleton;
import com.infoshare.academy.highfive.tool.ColorsSet;
import com.infoshare.academy.highfive.tool.DateValidatorUsingLocalDate;
import com.infoshare.academy.highfive.tool.TerminalCleaner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.*;
import java.util.stream.Collectors;

public class VacationPlanner {


    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private DateValidatorUsingLocalDate validator = new DateValidatorUsingLocalDate(dateFormatter);
    private List<Vacation> vacationList = VacationSingleton.getInstance().getVacationList();
    static final List<Employee> employeeList = EmployeeManagementSingleton.getInstance().getEmployeeList();
    private List<Holiday> holidayList = HolidaysSingleton.getInstance().getAllHolidays();
    static boolean matchedToPattern = false;
    static final String numberPattern = "[0-9]{1,2}";
    String datePattern = "^((?:(?:1[6-9]|2[0-9])\\d{2})(-)(?:(?:(?:0[13578]|1[02])(-)31)|((0[1,3-9]|1[0-2])(-)(29|30))))$|^(?:(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(-)02(-)29)$|^(?:(?:1[6-9]|2[0-9])\\d{2})(-)(?:(?:0[1-9])|(?:1[0-2]))(-)(?:0[1-9]|1\\d|2[0-8])$";

    public void chooseVacationType() throws Exception {

        stdout.info("\n" + "Please choose vacation type: \n");
        stdout.info("\n" + "1. Parental leave  \n");
        stdout.info("\n" + "2. Vacation leave  \n");
        Scanner scanner = getScanner();
        String vacationType = scanner.nextLine();
        if (vacationType.equals("1")) {
            planParentalLeave();
        } else if (vacationType.equals("2")) {
            planVacation();
        } else if (vacationType.equals("X")) {
                startMenu();

        } else {
            stdout.info("Please choose correct number or X to return to Main Menu");
            chooseVacationType();
        }
    }

    public void planParentalLeave() throws Exception {

        stdout.info("\n" + "Please follow instructions to add employee vacation \n");

        String nameToSearch = getEmployeeName();
//        String firstName = employeeName[0];
//        String secondName = employeeName[1];
        String employeeId = getEmployeeIdByScannerInput(nameToSearch);
        String entitlement = entitledParentalDaysOff(employeeId);
        String dateFrom = getDateFrom();
        String dateTo = getDateTo();
        List vacationDays = creatingVacationDaysList(dateFrom, dateTo);
        Integer daysOff = calculatingDaysAmount(vacationDays);
        dateFromPastDateToChecking(dateFrom, dateTo);
        checkIfEligible(daysOff, entitlement);
        addVacation(employeeId, dateFrom,dateTo);
        decreaseParentalEntitlement(employeeId, daysOff, entitlement);

    }

    public void planVacation() throws Exception {

        stdout.info("\n" + "Please follow instructions to add employee vacation \n");

        String nameToSearch = getEmployeeName();
//        String firstName = employeeName[0];
//        String secondName = employeeName[1];
        String employeeId = getEmployeeIdByScannerInput(nameToSearch);
        String entitlement = entitledVacationDaysOff(employeeId);
        String dateFrom = getDateFrom();
        String dateTo = getDateTo();
        List vacationDays = creatingVacationDaysList(dateFrom, dateTo);
        Integer daysOff = calculatingDaysAmount(vacationDays);
        dateFromPastDateToChecking(dateFrom, dateTo);
        checkIfEligible(daysOff, entitlement);
        addVacation(employeeId, dateFrom,dateTo);
        decreaseVacationEntitlement(employeeId, daysOff, entitlement);

    }

    protected String entitledVacationDaysOff(String employeeId) {

        return employeeList.stream()
                    .filter(e -> e.getEmployeeId().toString().equals(employeeId))
                    .findFirst().get().getHolidayEntitlement().toString();
    }

    protected String entitledParentalDaysOff(String employeeId) {

        return employeeList.stream()
                .filter(e -> e.getEmployeeId().toString().equals(employeeId))
                .findFirst().get().getAdditionalEntitlement().toString();
    }

    protected void checkIfEligible(Integer daysOff, String entitlement) throws Exception {

        if (daysOff > Integer.parseInt(entitlement)) {

            stdout.info("Given days are exceeding employee's entitlement, please type correct days. Current entitlement: " + entitlement + " days." );
            planVacation();

        }

    }

    protected void decreaseVacationEntitlement(String employeeId, Integer daysOff, String entitlement) throws Exception {

             employeeList.stream()
                .filter(e -> e.getEmployeeId().toString().equals(employeeId))
                .findFirst().get().setHolidayEntitlement(Integer.parseInt(entitlement) - daysOff).toString();

             saveAllEmployeeDb();
             startMenu();

    }

    protected void decreaseParentalEntitlement(String employeeId, Integer daysOff, String entitlement) throws Exception {

        employeeList.stream()
                .filter(e -> e.getEmployeeId().toString().equals(employeeId))
                .findFirst().get().setAdditionalEntitlement(Integer.parseInt(entitlement) - daysOff).toString();

        saveAllEmployeeDb();
        startMenu();

    }

    static void saveAllEmployeeDb() {
        EmployeeManagementSingleton.getInstance().saveEmployeesDb("employee_fdb.json");}

    protected void addVacation(String employeeId, String dateFrom, String dateTo ) {


        Vacation vacation = new Vacation(employeeId, dateFrom, dateTo);
        vacationList.add(vacation);
        saveVacationDb();
    }

    protected static String getEmployeeName() throws Exception {

        stdout.info("\n" + "Please type employee name or X to exit to Main Menu: \n");
        Scanner scanner = new Scanner(System.in);
 /*       String employee = scanner.nextLine();
        if (employee.equals("X")) {
            startMenu();

        } else {
            nameMatchToPattern(employee);
        }

        return employee.split(" ");*/
        String nameToSearch;
        do {
            stdout.info("Search by Full name: ");
            nameToSearch = scanner.nextLine().strip();
        } while (nameToSearch.length() == 0);
            return nameToSearch;
        }

    protected static String getEmployeeIdByScannerInput( String nameToSearch) {
        String employeeId;
        Scanner scanner = getScanner();

        do {
            stdout.info("Available employees, please choose employee ID \n");
            employeeList.stream()
                    //.filter(employee -> employee.getFirstName().equals(firstName))
                    .filter(l -> (l.getFirstName().toLowerCase() + " " + l.getSurname().toLowerCase()).contains(nameToSearch.toLowerCase()))
                   // .filter(employee -> employee.getSurname().equals(secondName))
                    .forEach(employee -> stdout.info("Employee ID: " + employee.getEmployeeId() + " | Employee first name " + employee.getFirstName()+ " | Employee second name:  " + employee.getSurname() + " | " + employee.getTeamName() + "\n"));

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

    protected String getDateFrom() throws ParseException {
        stdout.info("\n" + "Please type vacation start date in format YYYY-MM-DD: \n");

        Scanner scanner = new Scanner(System.in);
        String hireDateTemp;
        boolean matchedToDatePattern = false;
        do {
            stdout.info("Enter hire date (yyyy-mm-dd): ");
            hireDateTemp = scanner.nextLine();
            if (hireDateTemp.matches(datePattern)) {
                matchedToDatePattern = true;
            } else {
                stdout.info("WRONG_NO_MESSAGE");
            }
        } while (!matchedToDatePattern);
        LocalDate dateFrom = LocalDate.parse(hireDateTemp, DateTimeFormatter.ofPattern("yyyy-MM-dd").withResolverStyle(ResolverStyle.SMART));

        LocalDate localDate = LocalDate.now();
        //localDate.isBefore(dateFrom)

//        String localDateProperFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(localDate);
//        Date localDateProperFormatParsed = new SimpleDateFormat("yyyy-MM-dd").parse(localDateProperFormat);
//        Date dateFromDateFormat = new SimpleDateFormat("yyyy-MM-dd").parse(dateFrom);

        if (localDate.isAfter(dateFrom)) {
            stdout.info("Wrong input - try again\n");
            getDateFrom();
        }
        return dateFrom.format(DateTimeFormatter.ISO_DATE);
    }

    protected String getDateTo() {
        stdout.info("\n" + "Please type vacation end date in format YYYY-MM-DD: \n");

        Scanner scanner = new Scanner(System.in);
        String dateTo = scanner.nextLine();

        if (dateTo.matches(datePattern)) {
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
            else if (publicHolidaysList(holidayList).contains(day)) {

                holidays.add(day);
            }
        }

        return totalDates.size() - holidays.size();
    }

    private List publicHolidaysList(List<Holiday> holidayList) {

        List<HolidayDate> holidayDates = new LinkedList<>();

        List<Holiday> publicHolidayList= HolidaysSingleton.getInstance().getAllHolidays().stream().filter(h-> Array.get(h.getTypes(),0).equals(HolidayType.NATIONAL_HOLIDAY))
                .collect(Collectors.toList());

        publicHolidayList.stream().forEach(holiday -> holidayDates.add(holiday.getDate()));

         //FIXME make proper list

//        stdout.info(publicHolidayList.toString());

    return publicHolidayList;

    }

    static Scanner getScanner() {
        TerminalCleaner.cleanTerminal();
        return new Scanner(System.in);
    }

    protected static void saveVacationDb() {
        VacationSingleton.getInstance().saveVacationsDb("Vacation.json");

    }
    protected void startMenu() throws Exception {
        MainMenu mainMenu = new MainMenu();
        mainMenu.menuOptionsDisplay();
        mainMenu.getUserChoice();

}
}




