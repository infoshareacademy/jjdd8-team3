package com.infoshare.academy.highfive.vacation;

import com.infoshare.academy.highfive.employeemanager.Employee;
;
import com.infoshare.academy.highfive.employeemanager.EmployeeManagementSingleton;
import com.infoshare.academy.highfive.tool.DateValidatorUsingLocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class VacationRemoval extends VacationPlanner{

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private DateValidatorUsingLocalDate validator = new DateValidatorUsingLocalDate(dateFormatter);
    private List<Vacation> vacationList = VacationSingleton.getInstance().getVacationList();
    private static final List<Employee> employeeList = EmployeeManagementSingleton.getInstance().getEmployeeList();
    private static boolean matchedToPattern = false;
    private static final String numberPattern = "[0-9]{1,2}";
//
//    public List<Vacation> cancelVacation() throws Exception {
//
//        Scanner scanner = getScanner();
//        stdout.info("\n" + "Please follow instructions to cancel employee vacation \n");
//
////        String employeeName = getEmployeeName();
////        String employeeId = getEmployeeIdByScannerInput(scanner); //FIXME not working getemployeeid
//
//        String[] employeeId = getEmployeeName();
//        String dateFrom = getDateFrom();
//        String dateTo = getDateTo();
//        dateFromPastDateToChecking(dateFrom, dateTo);
//        Integer holidaysReturned = calculatingDaysAmount(creatingVacationDaysList(dateFrom, dateTo));
//        removeVacationFromDatabase(employeeId, dateFrom,dateTo);
//
//        return null;
//    }
    protected void removeVacationFromDatabase(String employeeId, String dateFrom, String dateTo ) {

        Vacation vacation = new Vacation(employeeId, dateFrom, dateTo);
        vacationList.remove(vacation);
        saveVacationDb();

        //FIXME overwriting file
    }

    //TODO function to update holidays entitlement and save to file

//    protected void cancelVacation(String employeeId, String dateFrom, String dateTo) {
//        Scanner scanner = getScanner();
//
//        List<Vacation> VacationListToAction = selectEmployeeByFullName(scanner);
//
//        if (employeeListToAction.size() > 0) {
//            String employeeIdx = getEmployeeIndexByScannerInput(scanner, employeeListToAction);
//
//            stdout.info("Type [Y]es to confirm or something else to exit:? ");
//            String confirm = scanner.nextLine().toLowerCase();
//            if (CONFIRMS.contains(confirm)) {
//                employeeList.remove(employeeListToAction.get(Integer.parseInt(employeeIdx)));
//                saveVacationDb();
//            }
//
//        }
//    }

}
