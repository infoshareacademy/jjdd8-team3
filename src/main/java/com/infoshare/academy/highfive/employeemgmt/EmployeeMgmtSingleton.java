package com.infoshare.academy.highfive.employeemgmt;

import com.infoshare.academy.highfive.holiday.ApiJsonParser;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

/*    public void initEmployeesDbFromFile(String fileName) throws IOException {

        Map<String, Object> mapLists = apiJsonParser.parseEmloyeesDb(fileName);
        teamList = (ArrayList<Team>) mapLists.get("teams");
        employeeList = (ArrayList<Employee>) mapLists.get("employees");
    }*/

    public void initFromFileTeam(String fileName) throws IOException {
        teamList = apiJsonParser.parseTeamFile(fileName);
    }

    public void initFromFileEmployee(String fileName) throws IOException {
        employeeList = apiJsonParser.parseEmployeeFile(fileName);
    }

    public void saveEmployeesDb(String filename) {
        Map<String, Object> mapLists = new TreeMap<>() {{ put("employees", employeeList); put("teams", teamList); }};
        apiJsonParser.saveEmployeesDb(filename, mapLists);
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }


}