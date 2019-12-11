package com.infoshare.academy.highfive.menuconsola;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class EmployeesManagingMenu extends MainMenu {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void runSubmenu() throws Exception {

        EmployeesManagingMenu employeesManagingMenu = new EmployeesManagingMenu();
        employeesManagingMenu.menuOptionsDisplay();
        employeesManagingMenu.getUserChoice();
    }

    @Override
    public void menuOptionsDisplay() {

        menuOptions.add("EMPLOYEES MANAGING");
        menuOptions.add("Display employees list");
        menuOptions.add("Add new employee");
        menuOptions.add("Remove an employee");
        menuOptions.add("Previous menu");

        stdout.info("\n\n" + menuOptions.get(0) + "\n\n");

        for (int i = 1; i < menuOptions.size(); i++) {

            stdout.info(i + ": " + menuOptions.get(i) + "\n");
        }
    }

    @Override
    public int getUserChoice() throws Exception {

        boolean matchedToPattern;
        stdout.info("\n" + "Choose option from 0 to " + (menuOptions.size() - 1) + "\n");
        Scanner scanner = new Scanner(System.in);
        String numberPattern = "[0-9]";
        userChoiceString = scanner.nextLine();
        matchedToPattern = userChoiceString.matches(numberPattern);
        if (!matchedToPattern) {
            stdout.info("Wrong input - try again\n");
            getUserChoice();
        }
        userChoice = Integer.parseInt(userChoiceString);

        if (userChoice > menuOptions.size() - 1 || userChoice == 0) {
            stdout.info("Wrong input - try again\n");
            getUserChoice();
        } else {
            switch (userChoice) {
                case 1:
                    stdout.info("\nDisplay employees list - UNDER CONSTRUCTION\n\n");
                    break;
                case 2:
                    stdout.info("\nAdd new employee - UNDER CONSTRUCTION\n\n");
                    break;
                case 3:
                    stdout.info("\nRemove an employee - UNDER CONSTRUCTION\n\n");
                    break;
                default:
                    MainMenu.runMenu();
            }
        }
        return userChoice;
    }
}