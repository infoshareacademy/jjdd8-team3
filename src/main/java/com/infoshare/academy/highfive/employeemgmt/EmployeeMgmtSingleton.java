package com.infoshare.academy.highfive.employeemgmt;

import com.infoshare.academy.highfive.holiday.ApiJsonParser;

import java.io.IOException;
import java.util.List;

public class EmployeeMgmtSingleton {
    ApiJsonParser apiJsonParser;
    private static EmployeeMgmtSingleton instance;
    private List<Team> teamList;
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

    public void initFromFileTeam(String fileName) throws IOException {
        teamList = apiJsonParser.parseTeamFile(fileName);
    }

    public void initSaveToFileTeam(String filename) {
        apiJsonParser.saveToFileTeam(filename, teamList);
    }

    public void initFromFileEmployee(String fileName) throws IOException {
        employeeList = apiJsonParser.parseEmployeeFile(fileName);
    }

    public void initSaveToFileEmployee(String filename) {
        apiJsonParser.saveToFileEmployee(filename, employeeList);
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }


}