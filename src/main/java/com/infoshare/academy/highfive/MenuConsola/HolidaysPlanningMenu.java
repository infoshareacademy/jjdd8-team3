package com.infoshare.academy.highfive.MenuConsola;

import com.infoshare.academy.highfive.HolidaysFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HolidaysPlanningMenu extends MainMenu {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main() throws Exception {

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
        stdout.info("\n" + "0: Exit" + "\n");
    }

    @Override
    public int getUserChoice() throws Exception {

        stdout.info("\n" + "Choose option from 0 to " + (menuOptions.size()-1) + "\n");

        try {
            Scanner scanner = new Scanner(System.in);
            scanner.useRadix(menuOptions.size());
            userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:    //form class HolidaysFilter
                    stdout.info("\nWyszukiwarka Świąt - PODPIĄĆ !!!!!" + "\n" + "\n");
                    HolidaysFilter.searchByDate();
                    break;
                case 2:   //form class HolidaysFilter
                    stdout.info("\nWyszukiwarka Świąt - PODPIĄĆ !!!!!" + "\n" + "\n");
                    HolidaysFilter.searchByName();
                    break;
                case 3:
                    stdout.info("\nAdd vacation- UNDER CONSTRUCTION\n\n");
                    break;
                case 4:
                    stdout.info("\nCancel vacation - UNDER CONSTRUCTION\n\n");
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