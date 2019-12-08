package MenuConsola1;

import MenuConsola.EmployeesManagingMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class MainMenu1 {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    public static int userChoice;
    List<String> menuOptions = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        MainMenu1 mainMenu1 = new MainMenu1();

        do {
            mainMenu1.menuOptionsDisplay();
            userChoice = mainMenu1.getUserChoice();
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
                    HolidaysPlanningMenu1.main();
                    break;
                case 2:
                    HolidaysReviewMenu1.main();
                    break;
                case 3:
                    EmployeesManagingMenu.main();
                    break;
                case 4:
                    ConfigurationMenu1.main();
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