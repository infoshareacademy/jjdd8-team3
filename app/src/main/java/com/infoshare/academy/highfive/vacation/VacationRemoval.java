package com.infoshare.academy.highfive.vacation;

import com.infoshare.academy.highfive.employeemanager.Employee;
import com.infoshare.academy.highfive.employeemanager.EmployeeManagementSingleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VacationRemoval extends VacationPlanner {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private List<Vacation> vacationList = VacationSingleton.getInstance().getVacationList();
    private static final List<Employee> employeeList = EmployeeManagementSingleton.getInstance().getEmployeeList();

    public void chooseVacationType() throws Exception {

        stdout.info("\n" + "Please choose vacation type number: \n");
        stdout.info("1. Parental leave \n");
        stdout.info("2. Vacation leave  \n");
        Scanner scanner = getScanner();
        String vacationType = scanner.nextLine();
        switch (vacationType) {
            case "1":
                cancelParental();
                break;
            case "2":
                cancelVacation();
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


    private void cancelParental() throws Exception {

        stdout.info("\n" + "Please follow instructions to cancel employee vacation \n");

        String nameToSearch = getEmployeeName();
        String employeeId = getEmployeeIdByScannerInput(nameToSearch);
        String entitlement = entitledParentalDaysOff(employeeId);
        String dateFrom = getDateFrom();
        String dateTo = getDateTo();
        List vacationDays = creatingVacationDaysList(dateFrom, dateTo);
        Integer daysOff = calculatingDaysAmount(vacationDays);
        dateFromPastDateToChecking(dateFrom, dateTo);
        removeVacationFromDatabase(employeeId, dateFrom, dateTo);
        increaseParentalEntitlement(employeeId, daysOff, entitlement);

    }

    private void cancelVacation() throws Exception {

        stdout.info("\n" + "Please follow instructions to cancel employee vacation \n");

        String nameToSearch = getEmployeeName();
        String employeeId = getEmployeeIdByScannerInput(nameToSearch);
        String entitlement = entitledVacationDaysOff(employeeId);
        String dateFrom = getDateFrom();
        String dateTo = getDateTo();
        List vacationDays = creatingVacationDaysList(dateFrom, dateTo);
        Integer daysOff = calculatingDaysAmount(vacationDays);
        dateFromPastDateToChecking(dateFrom, dateTo);
        checkIfEligible(daysOff, entitlement);
        removeVacationFromDatabase(employeeId, dateFrom, dateTo);
        increaseVacationEntitlement(employeeId, daysOff, entitlement);

    }

    protected void removeVacationFromDatabase(String employeeId, String dateFrom, String dateTo) {


        List<Vacation> vacToRemove = vacationList.stream()
                .filter(vacation1 -> vacation1.getEmployeeId().contains(employeeId))
                .filter(vacation1 -> vacation1.getDateFrom().contains(dateFrom))
                .filter(vacation1 -> vacation1.getDateTo().contains(dateTo))
                .collect(Collectors.toList());
        vacationList.removeAll(vacToRemove);

        saveVacationDb();

    }

    private void increaseParentalEntitlement(String employeeId, Integer daysOff, String entitlement) throws Exception {

        employeeList.stream()
                .filter(e -> e.getEmployeeId().toString().equals(employeeId))
                .findFirst().get().setAdditionalEntitlement(Integer.parseInt(entitlement) + daysOff);

        saveAllEmployeeDb();
        startMenu();

    }

    private void increaseVacationEntitlement(String employeeId, Integer daysOff, String entitlement) throws Exception {

        employeeList.stream()
                .filter(e -> e.getEmployeeId().toString().equals(employeeId))
                .findFirst().get().setHolidayEntitlement(Integer.parseInt(entitlement) + daysOff);

        saveAllEmployeeDb();
        startMenu();
    }
}
