package MenuConsola;

//    KONFIGURACJA PROGRAMU
//       Zmień format daty
//       Zmień sposob sortowania pracowników
//       Zmiana konfiguracji pliku zewnętrznego
//       powrót do poprzedniego menu

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

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
        menuOptions.add("Zmień sposób sortowania pracowników");
        menuOptions.add("Zmiana konfiguracji pliku zewnętrznego");
        menuOptions.add("Powrót do poprzedniego menu");

        stdout.info(menuHeadline + "\n" + "\n");

        for (int i = 0; i < menuOptions.size(); i++) {

            stdout.info((i + 1) + ": " + menuOptions.get(i) + "\n");
        }
    }
    @Override
    public int userChooses() throws Exception {

        stdout.info("\n" + "Wybierz opcję od 1 do " + menuOptions.size() + "\n");

        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();

        switch (userChoice) {
            case 1:
                stdout.info("Zmień format daty - under construction" + "\n" + "\n");
                break;
            case 2:
                stdout.info("Sposób sortowania - under construction" + "\n" + "\n");
                break;
            case 3:
                stdout.info("Konfig pliku zewnętrznego - under construction" + "\n" + "\n");
                break;
            case 4:
                break;
        }
        return userChoice;
    }
}
