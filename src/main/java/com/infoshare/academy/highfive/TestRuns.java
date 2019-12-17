package com.infoshare.academy.highfive;

import com.infoshare.academy.highfive.employeemgmt.EmployeeManager;
import com.infoshare.academy.highfive.employeemgmt.EmployeeMgmtSingleton;
import com.infoshare.academy.highfive.holiday.HolidaysSingleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class TestRuns {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main(String[] args) throws IOException {
        HolidaysSingleton.getInstance().initFromFile("holidays_save.json");
        EmployeeMgmtSingleton.getInstance().initFromFile("employee_fdb.json");
        //HolidaysSingleton.getInstance().initFromURL("https://calendarific.com/api/v2/holidays?&api_key=c2ddb57bb630fc01911bbcd01ae5907afaaced8e058cc0f33a938f517c0321e3&country=PL&year=2019");
        //HolidaysSingleton.getInstance().initSaveToFile("holidays_save.json");
        //EmployeeMgmtSingleton.getInstance().initSaveToFile("employee_save.json");
        //HolidaysFilter.searchByName();
        //HolidaysFilter.searchByDate();

        EmployeeManager.createEmployee();
        //EmployeeManager.removeEmployee();

    }
}
