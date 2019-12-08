package com.infoshare.academy.highfive;

import com.infoshare.academy.highfive.MenuConsola.MainMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class App {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void singletonInitialization() throws IOException {
        HolidaysSingleton.getInstance().initFromURL("https://calendarific.com/api/v2/holidays?&api_key=c2ddb57bb630fc01911bbcd01ae5907afaaced8e058cc0f33a938f517c0321e3&country=PL&year=2019");
        HolidaysSingleton.getInstance().initSaveToFile("2019.json");
    }

    public static void main(String[] args) throws Exception {
        singletonInitialization();
        MainMenu.runMenu();
    }
}
