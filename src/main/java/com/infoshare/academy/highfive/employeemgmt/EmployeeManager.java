package com.infoshare.academy.highfive.employeemgmt;

import com.infoshare.academy.highfive.holiday.HolidaysSingleton;
import com.infoshare.academy.highfive.tool.TerminalCleaner;
import com.infoshare.academy.highfive.vacation.VacationSingleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EmployeeManager {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private static String datePattern = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
    private static String numberPattern = "[0-9]{1,2}";
    private static boolean matchedToPattern = false;
    private static boolean matchedToDatePattern = false;
    private static List<Employee> employeeList = EmployeeMgmtSingleton.getInstance().getEmployeeList();

    private static Integer maxEmployeeIdNumber() {
        return Objects.requireNonNull(employeeList.stream()
                .max(Comparator.comparing(Employee::getEmployeeId))
                .orElse(null))
                .getEmployeeId();
    }

    private static List<Employee> findEmployeeBySurname(String nameToSearch) {
        return employeeList.stream()
                .filter(l -> l.getSurname().toLowerCase().contains(nameToSearch.toLowerCase()))
                .collect(Collectors.toList());

    }

    public static void createEmployee() {
        TerminalCleaner.cleanTerminal();
        stdout.info("New Employee Form\n");
        Scanner scanner = new Scanner(System.in);

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
        do {
            stdout.info("Enter hire date (yyyy-mm-dd): ");
            hireDateTemp = scanner.nextLine();
            matchedToDatePattern = hireDateTemp.matches(datePattern);
        } while (!matchedToDatePattern);
        LocalDate hireDate = LocalDate.parse(hireDateTemp);

        String holidayEntitlement;
        do {
            stdout.info("Enter Holiday entitlement: ");
            holidayEntitlement = scanner.nextLine();
            matchedToPattern = holidayEntitlement.matches(numberPattern);
        } while (!matchedToPattern);

        String additionalEntitlement;
        do {
            stdout.info("Enter additional entitlement : ");
            additionalEntitlement = scanner.nextLine();
            matchedToPattern = additionalEntitlement.matches(numberPattern);
        } while (!matchedToPattern);
        //TODO
/*        do {
            stdout.info("Choose Team : ");
            String team = scanner.nextLine();
        } while (false);*/

        Employee employee = new Employee(maxEmployeeIdNumber() + 1, firstName, surname, hireDate, Integer.parseInt(holidayEntitlement), Integer.parseInt(additionalEntitlement), new Team(1, "Developers"));
        EmployeeMgmtSingleton.getInstance().insertEmployee(employee);
        EmployeeMgmtSingleton.getInstance().initSaveToFile("employee_fdb.json");
    }

    public static void removeEmployee() {
        TerminalCleaner.cleanTerminal();
        stdout.info("Remove Employee\n");
        Scanner scanner = new Scanner(System.in);
        String surname;
        do {
            stdout.info("Search by Surname: ");
            surname = scanner.nextLine();
        } while (surname.length() == 0);

        List<Employee> employeeList = findEmployeeBySurname(surname);
        employeeList.forEach(l -> stdout.info("No " + employeeList.indexOf(l) + ". " + l.getSurname() + " " + l.getFirstName() + "\n"));

        if (employeeList.size() > 0) {
            String employeeIdx;
            do {
                stdout.info("Enter Employee No. or X to Cancel: ");
                employeeIdx = scanner.nextLine();
                if (employeeIdx.length() == 1 && employeeIdx.toLowerCase().equals("x")) {
                    break;
                }
                matchedToPattern = employeeIdx.matches(numberPattern);
                EmployeeMgmtSingleton.getInstance().deleteEmployeeByObj(employeeList.get(Integer.parseInt(employeeIdx)));
                EmployeeMgmtSingleton.getInstance().initSaveToFile("employee_fdb.json");
            } while (!matchedToPattern);
        }
    }
}
