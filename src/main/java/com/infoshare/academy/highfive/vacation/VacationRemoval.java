package com.infoshare.academy.highfive.vacation;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class VacationRemoval extends VacationPlanner{

    public List<Vacation> removeVacation() throws Exception {

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
