package com.infoshare.academy.highfive;

import com.infoshare.academy.highfive.menuconsola.MainMenu;
import com.infoshare.academy.highfive.holiday.HolidaysSingleton;
import com.infoshare.academy.highfive.tool.CleanTerminal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class App {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String checker = System.getProperty("os.name").toLowerCase();

    public static void initRepositoryFromFile() throws IOException {
        HolidaysSingleton.getInstance().initFromFile("Holidays.json");
    }

    private static void initRepositoryFromURL() throws IOException {
        HolidaysSingleton.getInstance().initFromURL("https://calendarific.com/api/v2/holidays?&api_key=c2ddb57bb630fc01911bbcd01ae5907afaaced8e058cc0f33a938f517c0321e3&country=PL&year=2019");
    }

    private static void saveToFileRepository() {
        HolidaysSingleton.getInstance().initSaveToFile("Export.json");
    }

    public static void main(String[] args) throws Exception {

        initRepositoryFromFile();
        CleanTerminal.cleanTerminal();
        MainMenu.runMenu();
    }
}
