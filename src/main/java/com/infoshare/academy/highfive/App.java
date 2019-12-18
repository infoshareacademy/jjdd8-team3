package com.infoshare.academy.highfive;

import com.infoshare.academy.highfive.consolmenu.MainMenu;
import com.infoshare.academy.highfive.employeemanager.EmployeeManagementSingleton;
import com.infoshare.academy.highfive.holiday.HolidaysSingleton;
import com.infoshare.academy.highfive.tool.TerminalCleaner;
import com.infoshare.academy.highfive.vacation.Vacation;
import com.infoshare.academy.highfive.vacation.VacationSingleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

public class App {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String checker = System.getProperty("os.name").toLowerCase();
    private static final String URL_PATH = "https://calendarific.com/api/v2/holidays?&api_key=c2ddb57bb630fc01911bbcd01ae5907afaaced8e058cc0f33a938f517c0321e3&country=PL&year=2019";
    private static final String FILENAME_TO_SAVE = "Holidays.json";
    private static final String FILE_NAME = "Holidays.json";
    public static final String FILE_NAME_FOR_EMPLOYEE = "employee_fdb.json";
    private static final String VACATION_FILENAME_TO_SAVE = "Export_vacation.json";
    private static final String VACATION_FILENAME = "Vacation.json";

    public static void initVacationRepositoryFromFile() throws IOException {
        VacationSingleton.getInstance().initFromFile(VACATION_FILENAME);

    }
    private static void saveVacationToFileRepository() {
        VacationSingleton.getInstance().initSaveToFile(VACATION_FILENAME_TO_SAVE);
    }

    private static void initRepositoryFromFiles() throws IOException {
        HolidaysSingleton.getInstance().initFromFile(FILE_NAME);
        EmployeeManagementSingleton.getInstance().initEmployeesDb("employee_fdb.json");
    }

    private static void initRepositoryFromURL() throws IOException {
        HolidaysSingleton.getInstance().initFromURL(URL_PATH);
    }

    private static void saveToFileRepository() {
        HolidaysSingleton.getInstance().initSaveToFile(FILENAME_TO_SAVE);
    }

    public static void main(String[] args) throws Exception {
        stdout.info("HIGH-FIVE TEAM \n");

        initRepositoryFromFiles();
        initVacationRepositoryFromFile();
        EmployeeManagementSingleton.getInstance().initEmployeesDb("employee_fdb.json");
        TerminalCleaner.cleanTerminal();
        MainMenu.runMenu();
    }
}
