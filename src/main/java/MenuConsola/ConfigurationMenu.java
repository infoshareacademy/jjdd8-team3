package MenuConsola;

//    PLANOWANIE URLOPÓW
//       Wyszukiwarka świąt
//       dodaj urlop
//       anuluj urlop
//       powrót do poprzedniego menu

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigurationMenu extends MainMenu{
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main() throws Exception {

        ConfigurationMenu holidaysPlanningMenu = new ConfigurationMenu();
        holidaysPlanningMenu.menuOptionsDisplay();
        holidaysPlanningMenu.userChooses();
    }

    @Override
    public void menuOptionsDisplay() {

        String menuHeadline = "PLANOWANIE URLOPÓW";

        menuOptions.add("Wyszukiwarka świąt");
        menuOptions.add("Dodaj urlop");
        menuOptions.add("Anuluj urlop");
        menuOptions.add("Powrót do poprzedniego menu");

        stdout.info(menuHeadline + "\n" + "\n");

        for (int i = 0; i < menuOptions.size(); i++) {

            stdout.info((i + 1) + ": " + menuOptions.get(i) + "\n");
        }
    }

}
