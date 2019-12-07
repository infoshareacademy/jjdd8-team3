package MenuConsola1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

//  MENU GŁÓWNE
//    PLANOWANIE URLOPÓW
//    PRZEGLĄDANIE URLOPÓW
//    ZARZĄDZANIE PRACOWNIKAMI
//    KONFIGURACJA PROGRAMU

public class MainMenu1 {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    public static int userChoice;
    List<String> menuOptions = new ArrayList<>();

//    public boolean hasNextInt(){};

    public static void main(String[] args) throws Exception {

        MainMenu1 mainMenu1 = new MainMenu1();

        do {
            mainMenu1.menuOptionsDisplay();
            userChoice = mainMenu1.userChooses();
        }
        while (userChoice != 0);
    }

    public void menuOptionsDisplay() {

        String menuHeadline = "MENU GŁÓWNE";

        menuOptions.clear();
        menuOptions.add("PLANOWANIE URLOPÓW");
        menuOptions.add("PRZEGLĄDANIE URLOPÓW");
        menuOptions.add("ZARZĄDZANIE PRACOWNIKAMI");
        menuOptions.add("KONFIGURACJA PROGRAMU");

        stdout.info(menuHeadline + "\n" + "\n");

        for (int i = 0; i < menuOptions.size(); i++) {

            stdout.info((i + 1) + ": " + menuOptions.get(i) + "\n");
        }
        stdout.info("\n" + "0: Wyjście z programu" + "\n");
    }

    public int userChooses() throws Exception {

        stdout.info("\n" + "Wybierz opcję od 0 do " + menuOptions.size() + "\n");
        try {
            Scanner scanner = new Scanner(System.in);
            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 0: break;
                case 1:
                    HolidaysPlanningMenu1.main();
                    break;
                case 2:
                    HolidaysReviewMenu1.main();
                    break;
                case 3:
                    EmployeesManageMenu1.main();
                    break;
                case 4:
                    ConfigurationMenu1.main();
                    break;
                default:
                    stdout.info("Wrong number - try again");
                    userChooses();
            }
        } catch (InputMismatchException e) {
            stdout.info("Not a number - try again");
            userChooses();
        }
        return userChoice;
    }
}