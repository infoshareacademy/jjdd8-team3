package com.infoshare.academy.highfive.MenuConsola;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConfigurationMenu extends MainMenu {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void runSubmenu() throws Exception {

        ConfigurationMenu configurationMenu = new ConfigurationMenu();
        configurationMenu.menuOptionsDisplay();
        configurationMenu.getUserChoice();
    }

    @Override
    public void menuOptionsDisplay() {

        menuOptions.add("CONFIGURATION");
        menuOptions.add("Change DATE format");
        menuOptions.add("Change employees SORTING mode");
        menuOptions.add("Change configuration of external file");
        menuOptions.add("Previous menu");

        stdout.info("\n\n" + menuOptions.get(0) + "\n\n");

        for (int i = 1; i < menuOptions.size(); i++) {

            stdout.info(i + ": " + menuOptions.get(i) + "\n");
        }
    }

    @Override
    public int getUserChoice() throws Exception {

        stdout.info("\n" + "Choose option from 1 to " + (menuOptions.size() - 1) + "\n");
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            stdout.info("Wrong input - try again\n");
            getUserChoice();
        }
        userChoice = scanner.nextInt();
        if (userChoice > menuOptions.size() - 1 || userChoice == 0) {
            stdout.info("Wrong input - try again\n");
            getUserChoice();
        } else {
            switch (userChoice) {
                case 1:
                    stdout.info("\nChange DATE format - UNDER CONSTRUCTION\n\n");
                    break;
                case 2:
                    stdout.info("\nChange employees SORTING mode - UNDER CONSTRUCTION\n\n");
                    break;
                case 3:
                    stdout.info("\nChange configuration of external file - UNDER CONSTRUCTION\n\n");
                    break;
                default:
                    MainMenu.runMenu();
            }
        }
        return userChoice;
    }
}