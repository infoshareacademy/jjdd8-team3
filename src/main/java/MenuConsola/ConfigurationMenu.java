package MenuConsola;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ConfigurationMenu extends MenuBuilder {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    @Override
    public void menuDisplay() {
        super.menuDisplay();
    }

    @Override
    public int getUserChoice() {
        super.getUserChoice();
        return userChoice;
    }

    private static List<String> setMenuOptions() {

        String menuHeadLine = "CONFIGURATION";
        String menuOption1 = "Change DATE format";
        String menuOption2 = "Change employees SORTING mode";
        String menuOption3 = "Change configuration of external file";
        String menuOption4 = "Previous menu";

        menuOptions.add(menuHeadLine);
        menuOptions.add(menuOption1);
        menuOptions.add(menuOption2);
        menuOptions.add(menuOption3);
        menuOptions.add(menuOption4);

        return menuOptions;
    }

    private static void executeUserChoice() {

        switch (userChoice) {
            case 0:
                break;
            case 1:
//                HolidaysPlanningMenu.main();
                break;
            case 2:
//                HolidaysReviewMenu.main();
                break;
            case 3:
//                EmployeesManageMenu.main();
                break;
            case 4:
//                ConfigurationMenu.main();
                break;
            case 5:
                break;

            default:
                stdout.info("Wrong number - try again");

        }
    }

    public static void main() {

        setMenuOptions();
        ConfigurationMenu menu = new ConfigurationMenu();
        menu.menuDisplay();
        menu.getUserChoice();
        executeUserChoice();
    }
}
