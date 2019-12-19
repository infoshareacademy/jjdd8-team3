package com.infoshare.academy.highfive.vacation;

import com.infoshare.academy.highfive.employeemanager.Employee;
;
import com.infoshare.academy.highfive.employeemanager.EmployeeManagementSingleton;
import com.infoshare.academy.highfive.tool.DateValidatorUsingLocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class VacationRemoval extends VacationPlanner{

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private DateValidatorUsingLocalDate validator = new DateValidatorUsingLocalDate(dateFormatter);
    private List<Vacation> vacationList = VacationSingleton.getInstance().getVacationList();
    private static final List<Employee> employeeList = EmployeeManagementSingleton.getInstance().getEmployeeList();
    private static boolean matchedToPattern = false;
    private static final String numberPattern = "[0-9]{1,2}";
    String datePattern = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";

    public void chooseVacationType() throws Exception {

        stdout.info("\n" + "Please choose vacation type: \n");
        stdout.info("\n" + "1. Parental leave  \n");
        stdout.info("\n" + "2. Vacation leave  \n");
        Scanner scanner = getScanner();
        String vacationType = scanner.nextLine();
        if (vacationType.equals("1")) {
            cancelParental();
        } if (vacationType.equals("2")) {
            cancelVacation();
        } if (vacationType.equals("X")) {
            startMenu();

        } else {
            stdout.info("Please choose correct number or X to return to Main Menu");
            chooseVacationType();
        }
    }

    //FIXME fix removal

    private void cancelParental() throws Exception {

        stdout.info("\n" + "Please follow instructions to cancel employee vacation \n");

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
        removeVacationFromDatabase(employeeId, dateFrom,dateTo);
        increaseParentalEntitlement(employeeId, daysOff, entitlement);

    }

    private void cancelVacation() throws Exception {

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
        removeVacationFromDatabase(employeeId, dateFrom,dateTo);
        increaseVacationEntitlement(employeeId, daysOff, entitlement);

    }
    protected void removeVacationFromDatabase(String employeeId, String dateFrom, String dateTo ) {

        Vacation vacation = new Vacation(employeeId, dateFrom, dateTo);
        vacationList.remove(vacation);
        saveVacationDb();

    }

    private void increaseParentalEntitlement(String employeeId, Integer daysOff, String entitlement) throws Exception {

        employeeList.stream()
                .filter(e -> e.getEmployeeId().toString().equals(employeeId))
                .findFirst().get().setAdditionalEntitlement(Integer.parseInt(entitlement) + daysOff).toString();

        saveAllEmployeeDb();
        startMenu();

    }
    private void increaseVacationEntitlement(String employeeId, Integer daysOff, String entitlement) throws Exception {

        employeeList.stream()
                .filter(e -> e.getEmployeeId().toString().equals(employeeId))
                .findFirst().get().setHolidayEntitlement(Integer.parseInt(entitlement) + daysOff).toString();

        saveAllEmployeeDb();
        startMenu();
    }
}
