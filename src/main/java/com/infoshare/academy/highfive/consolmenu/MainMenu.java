package com.infoshare.academy.highfive.consolmenu;

import com.infoshare.academy.highfive.tool.ColorsSet;
import com.infoshare.academy.highfive.tool.TerminalCleaner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    final List<String> menuOptions = new ArrayList<>();
    static String userChoiceString;
    static final String MAIN_MENU_TITLE = ("MAIN MENU");
    static final String HOLIDAYS_PLANNING_MENU_TITLE = ("HOLIDAY PLANNING");
    static final String HOLIDAYS_REVIEW_MENU_TITLE = ("HOLIDAYS REVIEW");
    static final String EMPLOYEES_MANAGING_MENU_TITLE = ("EMPLOYEES MANAGING");
    static final String CONFIGURATION_MENU_TITLE = ("CONFIGURATION");


    public static void runMenu() throws Exception {

        MainMenu mainMenu = new MainMenu();
        do {

            mainMenu.menuOptionsDisplay();
            mainMenu.getUserChoice();
        }
        while (!userChoiceString.equals("0"));
    }

    void menuOptionsDisplay() {

        TerminalCleaner.cleanTerminal();

        stdout.info("\n" + ColorsSet.ANSI_YELLOW + ">>>>> " + MAIN_MENU_TITLE + " / \n" + ColorsSet.ANSI_RESET);

        menuOptions.clear();
        menuOptions.add(MAIN_MENU_TITLE);
        menuOptions.add(HOLIDAYS_PLANNING_MENU_TITLE);
        menuOptions.add(HOLIDAYS_REVIEW_MENU_TITLE);
        menuOptions.add(EMPLOYEES_MANAGING_MENU_TITLE);
        menuOptions.add(CONFIGURATION_MENU_TITLE);

        stdout.info("\n\n" + menuOptions.get(0) + "\n\n");

        for (int i = 1; i < menuOptions.size(); i++) {

            stdout.info(i + ": " + menuOptions.get(i) + "\n");
        }
        stdout.info("\n" + "0: Exit" + "\n");
    }

    int getUserChoice() throws Exception {

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

        if ( Integer.parseInt(userChoiceString)> menuOptions.size() - 1) {
            stdout.info("Wrong input - try again\n");
            getUserChoice();
        } else {
            switch (Integer.parseInt(userChoiceString)) {
                case 0:
                    System.exit(0);
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
        }
        return Integer.parseInt(userChoiceString);
    }
}