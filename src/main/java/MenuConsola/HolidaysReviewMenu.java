package MenuConsola;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class HolidaysReviewMenu extends MenuBuilder {
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

        String menuHeadLine = "HOLIDAYS REVIEW";
        String menuOption1 = "Employee vacation review";
        String menuOption2 = "Team vacation review";
        String menuOption3 = "Previous menu";

        menuOptions.add(menuHeadLine);
        menuOptions.add(menuOption1);
        menuOptions.add(menuOption2);
        menuOptions.add(menuOption3);

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

            default:
                stdout.info("Wrong number - try again");
        }
    }

    public static void main() {

        setMenuOptions();
        HolidaysReviewMenu menu = new HolidaysReviewMenu();
        menu.menuDisplay();
        menu.getUserChoice();
        executeUserChoice();
    }
}
