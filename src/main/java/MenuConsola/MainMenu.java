package MenuConsola;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//  MENU GŁÓWNE
//    PLANOWANIE URLOPÓW
//    PRZEGLĄDANIE URLOPÓW
//    ZARZĄDZANIE PRACOWNIKAMI
//    KONFIGURACJA PROGRAMU

public class MainMenu {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    public static int userChoice;

    public static void main(String[] args) throws Exception {

        MainMenu mainMenu = new MainMenu();


        do {
           mainMenu.menuOptionsDisplay();
           userChoice = mainMenu.userChooses();
        }
         while(userChoice != 0);

    }

    List<String> menuOptions = new ArrayList<>();

    public void menuOptionsDisplay() {

        String menuHeadline = "MENU GŁÓWNE";

        menuOptions.clear();
        menuOptions.add("PLANOWANIE URLOPÓW");
        menuOptions.add("PRZEGLĄDANIE URLOPÓW");
        menuOptions.add("ZARZĄDZANIE PRACOWNIKAMI");
        menuOptions.add("KONFIGURACJA PROGRAMU");

        stdout.info (menuHeadline + "\n" + "\n");

        for (int i = 0; i < menuOptions.size() ; i++) {

          stdout.info( (i+1) + ": " + menuOptions.get(i) + "\n");
          }
        stdout.info("\n" + "0: Wyjście z programu" + "\n");
    }

    public int userChooses() throws Exception {

        stdout.info("\n" + "Wybierz opcję od 0 do " + menuOptions.size() + "\n");

        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();

       switch (userChoice){
            case 1 :
                HolidaysPlanningMenu.main();
                break;
           case 2 :
               HolidaysReviewMenu.main();
               break;
           case 3 :
               EmployeesManageMenu.main();
               break;
           case 4 :
               ConfigurationMenu.main();
               break;

       }
        return userChoice;

    }
}