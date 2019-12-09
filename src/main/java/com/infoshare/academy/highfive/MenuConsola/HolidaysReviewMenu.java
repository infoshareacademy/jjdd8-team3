package com.infoshare.academy.highfive.MenuConsola;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HolidaysReviewMenu extends MainMenu {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void runSubmenu() throws Exception {

        HolidaysReviewMenu holidaysReviewMenu = new HolidaysReviewMenu();
        holidaysReviewMenu.menuOptionsDisplay();
        holidaysReviewMenu.getUserChoice();
    }

    @Override
    public void menuOptionsDisplay() {

        menuOptions.add("HOLIDAYS REVIEW");
        menuOptions.add("Display employee vacation");
        menuOptions.add("Display team vacations");
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
                    stdout.info("\nDisplay employee vacation - UNDER CONSTRUCTION\n\n");
                    break;
                case 2:
                    stdout.info("\nDisplay team vacations - UNDER CONSTRUCTION\n\n");
                    break;
                default:
                    MainMenu.runMenu();
            }
        }
        return userChoice;
    }
}