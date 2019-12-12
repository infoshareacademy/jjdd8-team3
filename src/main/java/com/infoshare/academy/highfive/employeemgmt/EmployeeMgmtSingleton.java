package com.infoshare.academy.highfive.employeemgmt;

import com.infoshare.academy.highfive.holiday.ApiJsonParser;

import java.io.IOException;
import java.util.List;

public class EmployeeMgmtSingleton {
    ApiJsonParser apiJsonParser;
    private static EmployeeMgmtSingleton instance;
    private List<Employee> employeeList;

    private EmployeeMgmtSingleton() {
        apiJsonParser = new ApiJsonParser();
    }

    public static synchronized EmployeeMgmtSingleton getInstance() {
        if (instance == null) {
            instance = new EmployeeMgmtSingleton();
        }
        return instance;
    }

    public void initFromFile(String fileName) throws IOException {
        employeeList = apiJsonParser.parseEmployeeFile(fileName);
    }
}