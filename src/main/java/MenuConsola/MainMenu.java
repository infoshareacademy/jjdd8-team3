package MenuConsola;

import com.infoshare.academy.highfive.Holiday;
import com.infoshare.academy.highfive.HolidaysSingleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//    PLANOWANIE URLOPÓW
//       Wyszukiwarka świąt
//       dodaj urlop
//       anuluj urlop
//       powrót do poprzedniego menu
//    PRZEGLĄDANIE URLOPÓW
//       pracownika
//       zespołu
//       powrót do poprzedniego menu
//    ZARZĄDZANIE PRACOWNIKAMI
//       wyświetl listę pracowników
//       dodaj pracownika
//       usun pracownika
//       powrót do poprzedniego menu
//    KONFIGURACJA PROGRAMU
//       Zmień format daty
//       Zmień sposob sortowania pracowników
//       Zmiana konfiguracji pliku zewnętrznego
//       powrót do poprzedniego menu

public class MainMenu {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main(String[] args) throws Exception {

        MainMenu mainMenu = new MainMenu();
        mainMenu.menuOptionsDisplay();
        mainMenu.userChooses();
    }

    List<String> menuOptions = new ArrayList<>();

    public void menuOptionsDisplay() {

        String menuHeadline = "MENU GŁÓWNE";

        menuOptions.add("PLANOWANIE URLOPÓW");
        menuOptions.add("PRZEGLĄDANIE URLOPÓW");
        menuOptions.add("ZARZĄDZANIE PRACOWNIKAMI");
        menuOptions.add("KONFIGURACJA PROGRAMU");

        stdout.info (menuHeadline + "\n" + "\n");

        for (int i = 0; i < menuOptions.size() ; i++) {

          stdout.info( (i+1) + ": " + menuOptions.get(i) + "\n");
          }
    }

    public int userChooses() throws Exception {

        stdout.info("\n" + "Wybierz opcję od 1 do " + menuOptions.size() + "\n");

        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();

       switch (userChoice){
            case 1 :
                HolidaysPlanningMenu.main();
                break;

           case 2 :
               HolidaysSingleton.getInstance().getHolidays();
               break;

       }
        return userChoice;


    }
}