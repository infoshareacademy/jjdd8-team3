package com.infoshare.academy.highfive.mapper;

import com.infoshare.academy.highfive.employeemgmt.Employee;
import com.infoshare.academy.highfive.employeemgmt.Team;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class EmployeeManagementSingleton {
    private final ApiJsonParser apiJsonParser;
    private static EmployeeManagementSingleton instance;
    private List<Team> teamList;
    private List<Employee> employeeList;

    private EmployeeManagementSingleton() {
        apiJsonParser = new ApiJsonParser();
    }

    public static synchronized EmployeeManagementSingleton getInstance() {
        if (instance == null) {
            instance = new EmployeeManagementSingleton();
        }
        return instance;
    }

    public void initEmployeesDb(String fileName) throws IOException {
        teamList = apiJsonParser.parseTeamFile(fileName);
        employeeList = apiJsonParser.parseEmployeeFile(fileName);
    }

    public void saveEmployeesDb(String filename) {
        Map<String, Object> mapLists = new TreeMap<>();
        mapLists.put("employees", employeeList);
        mapLists.put("teams", teamList);
        apiJsonParser.saveEmployeesDb(filename, mapLists);
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

}