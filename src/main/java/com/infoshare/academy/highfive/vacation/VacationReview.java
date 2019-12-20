package com.infoshare.academy.highfive.vacation;

import com.infoshare.academy.highfive.employeemanager.Employee;
import com.infoshare.academy.highfive.employeemanager.EmployeeManagementSingleton;
import com.infoshare.academy.highfive.employeemanager.Team;
import com.infoshare.academy.highfive.tool.ColorsSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.infoshare.academy.highfive.vacation.VacationPlanner.*;


public class VacationReview {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private static List<Integer> employeesID = new ArrayList<>();
    private static List<Employee> employeeList = EmployeeManagementSingleton.getInstance().getEmployeeList();
    private static List<Team> listOfTeams = EmployeeManagementSingleton.getInstance().getTeamList();
    private static List<Vacation> vacations = VacationSingleton.getInstance().getVacationList();

    public static void displayEmployeeVacation() throws Exception {

        getIdByName();
        displayVacations();
    }

    public static void displayTeamVacation() throws Exception {

        getEmployeesIdsPerTeamByScannerInput(getTeamName());
        displayVacations();
    }

    static List<Integer> getIdByName() throws Exception {

       employeesID.add(Integer.parseInt(getEmployeeIdByScannerInput(getEmployeeName())));
        return employeesID;
    }

    private static String getTeamName() throws Exception {


        stdout.info("\n" + "Please input team name or X to exit to Main Menu: \n");
        Scanner scanner = new Scanner(System.in);

        String teamToSearch;
        do {
            stdout.info("Search by Team name: ");
            teamToSearch = scanner.nextLine().strip();
        } while (teamToSearch.length() == 0);
        return teamToSearch;
    }

    static List<Integer> getEmployeesIdsPerTeamByScannerInput(String teamToSearch) {

        String teamId;
        Scanner scanner = getScanner();
        Team team = new Team();
        //TODO Make employeeID, matchedtToPattern, numberPattern packege-privet when merging with Vacation planner

        do {
            stdout.info("Available teams, please choose team ID \n");

            listOfTeams.stream()
                    .filter(t -> (Integer.toString(t.getTeamId()).toLowerCase()).contains(teamToSearch.toLowerCase()))
                    .forEach(t -> stdout.info("team ID: " + team.getTeamId() + "Team Name: " + team.getTeamName() + "\n"));

            teamId = scanner.nextLine();
            matchedToPattern = teamId.matches(numberPattern);

            if (teamId.matches(numberPattern) && (Integer.parseInt(teamId) < listOfTeams.size()+1)) {
                matchedToPattern = true;
            } else{
                stdout.info(ColorsSet.ANSI_RED + "No such an ID in data base, please try again!\n" + ColorsSet.ANSI_RESET);
                matchedToPattern = false;
            }
        } while (!matchedToPattern);

        employeesID.add(Integer.parseInt(teamId));

        return employeesID;
    }

    //TODO : Get vacation list for defined ID(s)

    public static void displayVacations() {

//        listOfTeams.stream()
//            .filter(team -> employeesID.contains(team.getTeamId()))
//            .forEach(team -> stdout.info("TEAM: " + team.getTeamName() + " | id: " + team.getTeamId()));

        employeeList.stream()
                .filter(employee -> employeesID.contains(employee.getEmployeeId()))
                .forEach(employee -> stdout.info(
                        "TEAM: " + employee.getTeamName() + " |  NAME: "+ employee.getFirstName() + " " + employee.getSurname() + "VACATION: "
                        + vacations.contains(employee.getEmployeeId())));
    }

}
