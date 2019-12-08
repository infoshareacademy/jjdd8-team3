package MenuConsola1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConfigurationMenu1 extends MainMenu1 {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main() throws Exception {

        ConfigurationMenu1 configurationMenu1 = new ConfigurationMenu1();
        configurationMenu1.menuOptionsDisplay();
        configurationMenu1.getUserChoice();
    }

    @Override
    public void menuOptionsDisplay() {

        menuOptions.add("CONFIGURATION");
        menuOptions.add("Change DATE format");
        menuOptions.add("Change employees SORTING mode");
        menuOptions.add("Change configuration of external file");
        menuOptions.add("Previous menu");

        stdout.info("\n\n" + menuOptions.get(0) + "\n\n");

        for (int i = 1; i < menuOptions.size(); i++) {

            stdout.info(i + ": " + menuOptions.get(i) + "\n");
        }
    }

    @Override
    public int getUserChoice() throws Exception {

        stdout.info("\n" + "Choose option from 0 to " + (menuOptions.size()-1) + "\n");

        try {
            Scanner scanner = new Scanner(System.in);
            scanner.useRadix(menuOptions.size());
            userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    stdout.info("Change DATE format - UNDER CONSTRUCTION\n\n");
                    break;
                case 2:
                    stdout.info("Change employees SORTING mode - UNDER CONSTRUCTION\n\n");
                    break;
                case 3:
                    stdout.info("Change configuration of external file - UNDER CONSTRUCTION\n\n");
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