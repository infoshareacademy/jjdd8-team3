package com.infoshare.academy.highfive.consolmenu;

import com.infoshare.academy.highfive.employeemanager.EmployeeManager;
import com.infoshare.academy.highfive.tool.ColorsSet;
import com.infoshare.academy.highfive.tool.TerminalCleaner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

class EmployeesManagingMenu extends MainMenu {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void runSubmenu() throws Exception {

        EmployeesManagingMenu employeesManagingMenu = new EmployeesManagingMenu();
        employeesManagingMenu.menuOptionsDisplay();
        employeesManagingMenu.getUserChoice();
    }

    @Override
    void menuOptionsDisplay() {

        TerminalCleaner.cleanTerminal();

        stdout.info(ColorsSet.ANSI_YELLOW + ">>>>> " + MAIN_MENU_TITLE + " / " + EMPLOYEES_MANAGING_MENU_TITLE + " / \n" + ColorsSet.ANSI_RESET);

        menuOptions.add(EMPLOYEES_MANAGING_MENU_TITLE);
        menuOptions.add("Display employees list");
        menuOptions.add("Add new employee");
        menuOptions.add("Remove an employee");
        menuOptions.add("Change an employee team");
        menuOptions.add("Add new team");
        menuOptions.add("Rename team");
        menuOptions.add("Remove a team");
        menuOptions.add("Previous menu");

        stdout.info("\n\n" + menuOptions.get(0) + "\n\n");

        for (int i = 1; i < menuOptions.size(); i++) {

            stdout.info(i + ": " + menuOptions.get(i) + "\n");
        }
    }

    @Override
    int getUserChoice() throws Exception {

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

        if (Integer.parseInt(userChoiceString) > menuOptions.size() - 1 || Integer.parseInt(userChoiceString) == 0) {
            stdout.info("Wrong input - try again\n");
            getUserChoice();
        } else {
            switch (Integer.parseInt(userChoiceString)) {
                case 1:
                    EmployeeManager.listAllEmployees();
                    break;
                case 2:
                    EmployeeManager.createEmployee();
                    break;
                case 3:
                    EmployeeManager.deleteEmployee();
                    break;
                case 4:
                    EmployeeManager.moveEmployee();
                    break;
                case 5:
                    EmployeeManager.createTeam();
                    break;
                case 6:
                    EmployeeManager.renameTeam();
                    break;
                case 7:
                    EmployeeManager.removeTeam();
                    break;
                default:
                    MainMenu.runMenu();
            }
        }
        return Integer.parseInt(userChoiceString);
    }
}