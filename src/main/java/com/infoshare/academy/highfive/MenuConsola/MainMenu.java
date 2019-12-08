package com.infoshare.academy.highfive.MenuConsola;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    public static int userChoice;
    List<String> menuOptions = new ArrayList<>();

    public static void runMenu() throws Exception {

        MainMenu mainMenu = new MainMenu();

        do {
            mainMenu.menuOptionsDisplay();
            userChoice = mainMenu.getUserChoice();
        }
        while (userChoice != 0);
    }

    public void menuOptionsDisplay() {

        menuOptions.clear();
        menuOptions.add("MAIN MENU");
        menuOptions.add("HOLIDAY PLANNING");
        menuOptions.add("HOLIDAYS REVIEW");
        menuOptions.add("EMPLOYEES MANAGING");
        menuOptions.add("CONFIGURATION");

        stdout.info("\n\n" + menuOptions.get(0) + "\n\n");

        for (int i = 1; i < menuOptions.size(); i++) {

            stdout.info(i + ": " + menuOptions.get(i) + "\n");
        }
        stdout.info("\n" + "0: Exit" + "\n");
    }

    public int getUserChoice() throws Exception {

        stdout.info("\n" + "Choose option from 0 to " + (menuOptions.size()-1) + "\n");
        try {
            Scanner scanner = new Scanner(System.in);
            scanner.useRadix(menuOptions.size());
            userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    HolidaysPlanningMenu.runSubmenu();
                    break;
                case 2:
                    HolidaysReviewMenu.runSubmenu();
                    break;
                case 3:
                    EmployeesManagingMenu.runSubmenu();
                    break;
                case 4:
                    ConfigurationMenu.runSubmenu();
                    break;
                default:
                    break;
            }
        } catch (InputMismatchException e) {
        stdout.info("Wrong input - try again\n");
        getUserChoice();
        }
        return userChoice;
        }
}