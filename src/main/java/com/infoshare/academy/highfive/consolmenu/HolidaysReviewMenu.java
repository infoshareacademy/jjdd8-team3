package com.infoshare.academy.highfive.consolmenu;

import com.infoshare.academy.highfive.tool.CalendarDisplay;
import com.infoshare.academy.highfive.tool.ColorsSet;
import com.infoshare.academy.highfive.tool.TerminalCleaner;
import com.infoshare.academy.highfive.vacation.VacationReview;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

class HolidaysReviewMenu extends MainMenu {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void runSubmenu() throws Exception {

        HolidaysReviewMenu holidaysReviewMenu = new HolidaysReviewMenu();
        holidaysReviewMenu.menuOptionsDisplay();
        holidaysReviewMenu.getUserChoice();
    }

    @Override
    public void menuOptionsDisplay() {

        TerminalCleaner.cleanTerminal();

        stdout.info(ColorsSet.ANSI_YELLOW + ">>>>> " + MAIN_MENU_TITLE + " / " + HOLIDAYS_REVIEW_MENU_TITLE +" / \n" + ColorsSet.ANSI_RESET);

        menuOptions.add(HOLIDAYS_REVIEW_MENU_TITLE);
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

        if (Integer.parseInt(userChoiceString)> menuOptions.size() - 1 || Integer.parseInt(userChoiceString)== 0) {
            stdout.info("Wrong input - try again\n");
            getUserChoice();
        } else {
            switch (Integer.parseInt(userChoiceString)) {
                case 1:
                  // EmployeeManager.listAllEmployees();
                    stdout.info("Enter id: ");
                    CalendarDisplay.printMothsCalendar(VacationReview.getIdByName());
                    stdout.info("Type [1] to search again or something else to exit: ");

                   String inputTxt = scanner.nextLine();
                    if (inputTxt.length() == 1 && inputTxt.equals("1")) {

                    }
                    break;
                case 2:
                    stdout.info("\nDisplay team vacations - UNDER CONSTRUCTION\n\n");
                    break;
                default:
                    MainMenu.runMenu();
            }
        }
        return Integer.parseInt(userChoiceString);
    }
}