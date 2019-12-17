package com.infoshare.academy.highfive.vacation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class VacationRemoval extends VacationPlanner{

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    public List<Vacation> removeVacation() throws Exception {

        stdout.info("\n" + "Please follow instructions to cancel employee vacation \n");

        String employeeName = getEmployeeName();
        int employeeId = returnEmployeeId(employeeName);
        String dateFrom = getDateFrom();
        String dateTo = getDateTo();
        dateFromPastDateToChecking(dateFrom, dateTo);
        int holidaysRecovered = calculatingDaysAmount(creatingVacationDaysList(dateFrom, dateTo));

        //TODO function to cancel vacation and save to file
        //TODO function to update holidays entitlement and save to file

        List<Vacation> vacations = new ArrayList<>();
        return vacations;
    }




}
