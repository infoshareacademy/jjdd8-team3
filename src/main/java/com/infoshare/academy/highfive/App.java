package com.infoshare.academy.highfive;

import com.infoshare.academy.highfive.consolemenu.MainMenu;
import com.infoshare.academy.highfive.holiday.HolidaysSingleton;
import com.infoshare.academy.highfive.tool.TerminalCleaner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

public class App {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String checker = System.getProperty("os.name").toLowerCase();
    private static final String urlPath = "https://calendarific.com/api/v2/holidays?&api_key=c2ddb57bb630fc01911bbcd01ae5907afaaced8e058cc0f33a938f517c0321e3&country=PL&year=2019";
    private static final String filenameToSave = "Export_holidays.json";
    private static final String fileName = "Holidays.json";

    public static void initRepositoryFromFile() throws IOException {
        HolidaysSingleton.getInstance().initFromFile(fileName);
    }

    private static void initRepositoryFromURL() throws IOException {
        HolidaysSingleton.getInstance().initFromURL(urlPath);
    }

    private static void saveToFileRepository() {
        HolidaysSingleton.getInstance().initSaveToFile(filenameToSave);
    }

    public static void main(String[] args) throws Exception {

        initRepositoryFromFile();
        TerminalCleaner.cleanTerminal();
        MainMenu.runMenu();
    }
}
