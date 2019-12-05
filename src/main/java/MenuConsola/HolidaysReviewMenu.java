package MenuConsola;

//    PRZEGLĄDANIE URLOPÓW
//       pracownika
//       zespołu
//       powrót do poprzedniego menu

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HolidaysReviewMenu extends MainMenu{
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main() throws Exception {

        HolidaysReviewMenu holidaysPlanningMenu = new HolidaysReviewMenu();
        holidaysPlanningMenu.menuOptionsDisplay();
        holidaysPlanningMenu.userChooses();
    }

    @Override
    public void menuOptionsDisplay() {

        String menuHeadline = "PRZEGLĄDANIE URLOPÓW";

        menuOptions.add("Przeglądanie urlopów pracownika");
        menuOptions.add("Przeglądanie urlopów zespółu");
        menuOptions.add("Powrót do poprzedniego menu");

        stdout.info(menuHeadline + "\n" + "\n");

        for (int i = 0; i < menuOptions.size(); i++) {

            stdout.info((i + 1) + ": " + menuOptions.get(i) + "\n");
        }
    }

}
