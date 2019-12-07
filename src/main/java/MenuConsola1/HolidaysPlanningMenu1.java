package MenuConsola1;

//    PLANOWANIE URLOPÓW
//       Wyszukiwarka świąt
//       dodaj urlop
//       anuluj urlop
//       powrót do poprzedniego menu

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class HolidaysPlanningMenu1 extends MainMenu1 {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main() throws Exception {

        HolidaysPlanningMenu1 holidaysPlanningMenu = new HolidaysPlanningMenu1();
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

    @Override
    public int userChooses() throws Exception {

        stdout.info("\n" + "Wybierz opcję od 1 do " + menuOptions.size() + "\n");

        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();

        switch (userChoice){
            case 1 :
                stdout.info("Wyszukiwarka Świąt - PODPIĄĆ !!!!!" + "\n" + "\n");
                break;
            case 2 :
                stdout.info("Dodaj urlop - under construction" + "\n" + "\n");
                break;
            case 3 :
                stdout.info("Anuluj urlop - under construction" + "\n" + "\n");
                break;
            case 4 :
                break;

        }
        return userChoice;
    }

}