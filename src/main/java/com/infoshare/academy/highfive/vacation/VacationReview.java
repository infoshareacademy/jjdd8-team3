package com.infoshare.academy.highfive.vacation;

import com.infoshare.academy.highfive.employeemanager.Employee;
import com.infoshare.academy.highfive.employeemanager.EmployeeManagementSingleton;
import com.infoshare.academy.highfive.employeemanager.Team;
import com.infoshare.academy.highfive.tool.ColorsSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static com.infoshare.academy.highfive.vacation.VacationPlanner.*;
import com.infoshare.academy.highfive.employeemanager.Team.*;


public class VacationReview {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private List<String> employeesID;
    private final List<Employee> employeeList = EmployeeManagementSingleton.getInstance().getEmployeeList();
    private final List<Vacation> vacations = VacationSingleton.getInstance().getVacationList();

    public static void displayEmployeeVacation(){

    }
    public static void displayTeamVacation() throws Exception {

        getEmployeeIdByScannerInput(getTeamName());
        displayVacations();
    }

    List<String> getIdByName() throws Exception {

       employeesID.add(getEmployeeIdByScannerInput(getEmployeeName()));
       return employeesID;
    }

    //TODO : Get ID by Team

    protected static String getTeamName() throws Exception {

        stdout.info("\n" + "Please input team name or X to exit to Main Menu: \n");
        Scanner scanner = new Scanner(System.in);

        String teamToSearch;
        do {
            stdout.info("Search by Full name: ");
            teamToSearch = scanner.nextLine().strip();
        } while (teamToSearch.length() == 0);
        return teamToSearch;
    }

    protected List<String> getEmployeesIdsPerTeamByScannerInput( String teamToSearch) {

        String employeeId;
        Scanner scanner = getScanner();

        do {
            stdout.info("Available employees, please choose employee ID \n");


            employeeList.stream()
                    .filter(l -> (l.getTeamName().getTeamName())
                    .contains(teamToSearch))
                    .forEach(employee -> stdout.info("Employee ID: " + employee.getEmployeeId() + " | Employee first name " + employee.getFirstName() + " | Employee second name:  " + employee.getSurname() + " | " + employee.getTeamName() + "\n"));

            employeeId = scanner.nextLine();
//TODO Make employeeID, matchedtToPattern, numberPattern packege-privet when merging with Vacation planner
            matchedToPattern = employeeId.matches(numberPattern);
            if (employeeId.matches(numberPattern) && (Integer.parseInt(employeeId) < employeeList.size())) {
                matchedToPattern = true;
            } else {
                stdout.info(ColorsSet.ANSI_RED + "Wrong No., please try again!\n" + ColorsSet.ANSI_RESET);
                matchedToPattern = false;
            }

        } while (!matchedToPattern);

        return employeesID;
    }



    //TODO : Get vacation list for defined ID(s)

    public void displayVacations(){

        employeeList.stream()
                .filter(employee -> employeesID.contains(employee.getEmployeeId()))
                .forEach(employee -> stdout.info(employee.getFirstName() + " " + employee.getSurname() + ": "
                + vacations.contains(employee.getEmployeeId())));
}

}
