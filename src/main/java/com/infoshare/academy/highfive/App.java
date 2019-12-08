package com.infoshare.academy.highfive;

import com.infoshare.academy.highfive.MenuConsola.MainMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main(String[] args) throws Exception {
        stdout.info("Start");
        MainMenu.runMenu();
    }
}
