package com.infoshare.academy.highfive.employeemgmt;

import com.infoshare.academy.highfive.tool.ColorsSet;
import com.infoshare.academy.highfive.tool.TerminalCleaner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeManager {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final Set<String> CONFIRMS = Set.of("y", "yes");
    private static String datePattern = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
    private static String numberPattern = "[0-9]{1,2}";
    private static boolean matchedToPattern = false;
    private static List<Employee> employeeList = EmployeeMgmtSingleton.getInstance().getEmployeeList();
    private static List<Team> teamList = EmployeeMgmtSingleton.getInstance().getTeamList();

    private static Integer maxEmployeeIdNumber() {
        return Objects.requireNonNull(employeeList.stream()
                .max(Comparator.comparing(Employee::getEmployeeId))
                .orElse(null))
                .getEmployeeId();
    }

    private static Integer maxTeamIdNumber() {
        return Objects.requireNonNull(teamList.stream()
                .max(Comparator.comparing((Team::getTeamId)))
                .orElse(null))
                .getTeamId();
    }

    private static List<Employee> findEmployeeByFullName(String nameToSearch) {
        return employeeList.stream()
                .filter(l -> (l.getFirstName().toLowerCase() + " " + l.getSurname().toLowerCase()).contains(nameToSearch.toLowerCase()))
                .collect(Collectors.toList());
    }

    private static Scanner getScanner() {
        TerminalCleaner.cleanTerminal();
        return new Scanner(System.in);
    }

    private static void saveAllEmployeeMgmt() {
        EmployeeMgmtSingleton.getInstance().initSaveToFileTeam("team_fdb.json");
        EmployeeMgmtSingleton.getInstance().initSaveToFileEmployee("employee_fdb.json");
    }

    public static void createEmployee() {
        Scanner scanner = getScanner();
        stdout.info(">>> New Employee Form <<<\n");

        String firstName;
        do {
            stdout.info("Enter name: ");
            firstName = scanner.nextLine();
        } while (firstName.length() == 0);

        String surname;
        do {
            stdout.info("Enter Surname: ");
            surname = scanner.nextLine();
        } while (surname.length() == 0);

        String hireDateTemp;
        boolean matchedToDatePattern = false;
        do {
            stdout.info("Enter hire date (yyyy-mm-dd): ");
            hireDateTemp = scanner.nextLine();
            if (hireDateTemp.matches(datePattern)) {
                matchedToDatePattern = true;
            } else {
                stdout.info(ColorsSet.ANSI_RED + "Wrong No., please try again!\n" + ColorsSet.ANSI_RESET);
            }
        } while (!matchedToDatePattern);
        LocalDate hireDate = LocalDate.parse(hireDateTemp);

        String holidayEntitlement;
        do {
            stdout.info("Enter Holiday entitlement (2 digit): ");
            holidayEntitlement = scanner.nextLine();
            if (holidayEntitlement.matches(numberPattern)) {
                matchedToPattern = true;
            } else {
                stdout.info(ColorsSet.ANSI_RED + "Wrong No., please try again!\n" + ColorsSet.ANSI_RESET);
                matchedToPattern = false;
            }
        } while (!matchedToPattern);

        String additionalEntitlement;
        do {
            stdout.info("Enter additional entitlement (2 digit): ");
            additionalEntitlement = scanner.nextLine();
            if (additionalEntitlement.matches(numberPattern)) {
                matchedToPattern = true;
            } else {
                stdout.info(ColorsSet.ANSI_RED + "Wrong No., please try again!\n" + ColorsSet.ANSI_RESET);
                matchedToPattern = false;
            }
        } while (!matchedToPattern);

        String teamIdx;
        do {
            stdout.info("Available Teams for Employee >>>\n");
            teamList.forEach(l -> stdout.info(teamList.indexOf(l) + ". " + l.getTeamName() + " | "));
            stdout.info("\n<<<\nSelect team: ");
            teamIdx = scanner.nextLine();
            matchedToPattern = teamIdx.matches(numberPattern);
            if (teamIdx.matches(numberPattern) && (Integer.parseInt(teamIdx) < teamList.size())) {
                matchedToPattern = true;
            } else {
                stdout.info(ColorsSet.ANSI_RED + "Wrong No., please try again!\n" + ColorsSet.ANSI_RESET);
                matchedToPattern = false;
            }

        } while (!matchedToPattern);

        stdout.info("Type [Y]es to confirm or something else to exit:? ");
        String confirm = scanner.nextLine().toLowerCase();
        if (CONFIRMS.contains(confirm)) {
            Employee employee = new Employee(maxEmployeeIdNumber() + 1, firstName, surname, hireDate, Integer.parseInt(holidayEntitlement), Integer.parseInt(additionalEntitlement), teamList.get(Integer.parseInt(teamIdx)));
            employeeList.add(employee);
            saveAllEmployeeMgmt();
        }
    }

    public static void deleteEmployee() {
        Scanner scanner = getScanner();
        stdout.info(">>> Remove Employee <<<\n");
        String nameToSearch;
        do {
            stdout.info("Search by Full name: ");
            nameToSearch = scanner.nextLine().strip();
        } while (nameToSearch.length() == 0);

        List<Employee> employeeListToAction = findEmployeeByFullName(nameToSearch);
        employeeListToAction.forEach(l -> stdout.info("No " + employeeListToAction.indexOf(l) + ". " + l.getFirstName() + " " + l.getSurname() + " " + l.getTeamName().getTeamName() + "\n"));

        if (employeeListToAction.size() > 0) {
            String employeeIdx;
            do {
                stdout.info("Enter Employee No.: ");
                employeeIdx = scanner.nextLine();
                if (employeeIdx.matches(numberPattern) && (Integer.parseInt(employeeIdx) < employeeListToAction.size())) {
                    matchedToPattern = true;
                } else {
                    stdout.info(ColorsSet.ANSI_RED + "Wrong No., please try again!\n" + ColorsSet.ANSI_RESET);
                    matchedToPattern = false;
                }
            } while (!matchedToPattern);

            stdout.info("Type [Y]es to confirm or something else to exit:? ");
            String confirm = scanner.nextLine().toLowerCase();
            if (CONFIRMS.contains(confirm)) {
                employeeList.remove(employeeListToAction.get(Integer.parseInt(employeeIdx)));
                saveAllEmployeeMgmt();
            }
        }
    }

    public static void moveEmployee() {
        Scanner scanner = getScanner();
        stdout.info(">>> Move Employee <<<\n");
        String nameToSearch;
        do {
            stdout.info("Search by Full name: ");
            nameToSearch = scanner.nextLine().strip();
        } while (nameToSearch.length() == 0);

        List<Employee> employeeListToAction = findEmployeeByFullName(nameToSearch);
        employeeListToAction.forEach(l -> stdout.info("No " + employeeListToAction.indexOf(l) + ". " + l.getFirstName() + " " + l.getSurname() + " " + l.getTeamName().getTeamName() + "\n"));

        if (employeeListToAction.size() > 0) {
            String employeeIdx;
            do {
                stdout.info("Enter Employee No.: ");
                employeeIdx = scanner.nextLine();
                if (employeeIdx.matches(numberPattern) && (Integer.parseInt(employeeIdx) < employeeListToAction.size())) {
                    matchedToPattern = true;
                } else {
                    stdout.info(ColorsSet.ANSI_RED + "Wrong No., please try again!\n" + ColorsSet.ANSI_RESET);
                    matchedToPattern = false;
                }
            } while (!matchedToPattern);

            String teamIdx;
            do {
                stdout.info("Available Teams for Employee >>>\n");
                teamList.forEach(l -> stdout.info(teamList.indexOf(l) + ". " + l.getTeamName() + " | "));
                stdout.info("\n<<<\nSelect team: ");
                teamIdx = scanner.nextLine();
                matchedToPattern = teamIdx.matches(numberPattern);
                if (teamIdx.matches(numberPattern) && (Integer.parseInt(teamIdx) < teamList.size())) {
                    matchedToPattern = true;
                } else {
                    stdout.info(ColorsSet.ANSI_RED + "Wrong No., please try again!\n" + ColorsSet.ANSI_RESET);
                    matchedToPattern = false;
                }

            } while (!matchedToPattern);
            stdout.info("Type [Y]es to confirm or something else to exit:? ");
            String confirm = scanner.nextLine().toLowerCase();
            if (CONFIRMS.contains(confirm)) {
                Employee employee = employeeListToAction.get(Integer.parseInt(employeeIdx));
                employee.setTeamName(teamList.get(Integer.parseInt(teamIdx)));
                saveAllEmployeeMgmt();
            }
        }
    }

    public static void createTeam() {
        Scanner scanner = getScanner();
        stdout.info(">>> Add new team <<<\n");

        String teamName;
        do {
            stdout.info("Enter Team name: ");
            teamName = scanner.nextLine();
        } while (teamName.length() == 0);
        stdout.info("Type [Y]es to confirm or something else to exit:? ");
        String confirm = scanner.nextLine().toLowerCase();
        if (CONFIRMS.contains(confirm)) {
            teamList.add(new Team(maxTeamIdNumber() + 1, teamName));
            saveAllEmployeeMgmt();
        }
    }

    public static void removeTeam() {
        Scanner scanner = getScanner();
        stdout.info(">>> Remove team <<<\n");
        String teamIdx;
        do {
            stdout.info("Available Teams to remove >>>\n");
            teamIdx = displayTeamSelect(scanner);
        } while (!matchedToPattern);

        stdout.info("Type [Y]es to confirm or something else to exit:? ");
        String confirm = scanner.nextLine().toLowerCase();
        if (CONFIRMS.contains(confirm)) {
            Team teamToRemove = teamList.get(Integer.parseInt(teamIdx));
            Team defaultTeam = teamList.get(0);
            employeeList.stream().filter(l -> l.getTeamName().equals(teamToRemove)).forEach(fl -> fl.setTeamName(defaultTeam));
            teamList.remove(teamToRemove);
            stdout.info("All employees from deleted team moved to " +defaultTeam.getTeamName());
            saveAllEmployeeMgmt();
        }
    }

    public static void renameTeam() {
        Scanner scanner = getScanner();
        stdout.info(">> Rename team <<\n");
        String teamIdx;
        do {
            stdout.info("Available Teams to rename >>>\n");
            teamIdx = displayTeamSelect(scanner);
        } while (!matchedToPattern);

        String teamName;
        do {
            stdout.info("Enter New Team name: ");
            teamName = scanner.nextLine();
        } while (teamName.length() == 0);

        stdout.info("Type [Y]es to confirm or something else to exit:? ");
        String confirm = scanner.nextLine().toLowerCase();
        if (CONFIRMS.contains(confirm)) {
            Team renamedTeam = teamList.get(Integer.parseInt(teamIdx));
            renamedTeam.setTeamName(teamName);
            saveAllEmployeeMgmt();
        }
    }

    private static String displayTeamSelect(Scanner scanner) {
        String teamIdx;
        teamList.forEach(l -> stdout.info(teamList.indexOf(l) + ". " + l.getTeamName() + " | "));
        stdout.info("\n<<<\nSelect team: ");
        teamIdx = scanner.nextLine();
        if (teamIdx.matches(numberPattern) && Integer.parseInt(teamIdx) < teamList.size()) {
            matchedToPattern = true;
        } else {
            stdout.info(ColorsSet.ANSI_RED + "Wrong No., please try again!\n" + ColorsSet.ANSI_RESET);
            matchedToPattern = false;
            return teamIdx;
        }
        return teamIdx;
    }
}
