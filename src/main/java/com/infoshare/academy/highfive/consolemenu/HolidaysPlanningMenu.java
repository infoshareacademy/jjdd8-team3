package com.infoshare.academy.highfive.consolemenu;

import com.infoshare.academy.highfive.holiday.HolidaysFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class HolidaysPlanningMenu extends MainMenu {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void runSubmenu() throws Exception {

        HolidaysPlanningMenu holidaysPlanningMenu = new HolidaysPlanningMenu();
        holidaysPlanningMenu.menuOptionsDisplay();
        holidaysPlanningMenu.getUserChoice();
    }

    @Override
    public void menuOptionsDisplay() {

        menuOptions.add("HOLIDAY PLANNING");
        menuOptions.add("Search holiday by DATE");
        menuOptions.add("Search holiday by NAME");
        menuOptions.add("Add vacation");
        menuOptions.add("Cancel vacation");
        menuOptions.add("Previous menu");

        stdout.info("\n\n" + menuOptions.get(0) + "\n\n");

        for (int i = 1; i < menuOptions.size(); i++) {

            stdout.info(i + ": " + menuOptions.get(i) + "\n");
        }

    }

    @Override
    public int getUserChoice() throws Exception {

        boolean matchedToPattern;
        stdout.info("\n" + "Choose option from 1 to " + (menuOptions.size() - 1) + "\n");
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
                    HolidaysFilter.searchByDate();
                    break;
                case 2:
                    HolidaysFilter.searchByName();
                    break;
                case 3:
                    stdout.info("\nAdd vacation- UNDER CONSTRUCTION\n\n");
                    break;
                case 4:
                    stdout.info("\nCancel vacation - UNDER CONSTRUCTION\n\n");
                    break;
                default:
                    MainMenu.runMenu();
            }
        }
        return userChoice;
    }
}