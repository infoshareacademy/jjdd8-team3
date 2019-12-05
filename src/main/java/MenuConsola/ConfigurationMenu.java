package MenuConsola;

//    KONFIGURACJA PROGRAMU
//       Zmień format daty
//       Zmień sposob sortowania pracowników
//       Zmiana konfiguracji pliku zewnętrznego
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

        String menuHeadline = "KONFIGURACJA PROGRAMU";

        menuOptions.add("Zmień format daty");
        menuOptions.add("Zmień sposob sortowania pracowników");
        menuOptions.add("Zmiana konfiguracji pliku zewnętrznego");
        menuOptions.add("Powrót do poprzedniego menu");

        stdout.info(menuHeadline + "\n" + "\n");

        for (int i = 0; i < menuOptions.size(); i++) {

            stdout.info((i + 1) + ": " + menuOptions.get(i) + "\n");
        }
    }

}
