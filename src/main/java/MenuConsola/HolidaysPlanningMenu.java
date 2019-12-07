package MenuConsola;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class HolidaysPlanningMenu extends MenuBuilder {
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

        String menuHeadLine = "HOLIDAY PLANNING";
        String menuOption1 = "Search holiday by DATE";
        String menuOption2 = "Search holiday by NAME";
        String menuOption3 = "Add vacation";
        String menuOption4 = "Cancel vacation";
        String menuOption5 = "Previous menu";

        menuOptions.add(menuHeadLine);
        menuOptions.add(menuOption1);
        menuOptions.add(menuOption2);
        menuOptions.add(menuOption3);
        menuOptions.add(menuOption4);
        menuOptions.add(menuOption5);

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
        HolidaysPlanningMenu menu = new HolidaysPlanningMenu();
        menu.menuDisplay();
        menu.getUserChoice();
        executeUserChoice();
    }
}