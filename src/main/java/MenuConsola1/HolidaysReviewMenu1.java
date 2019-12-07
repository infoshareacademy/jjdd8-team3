package MenuConsola1;

//    PRZEGLĄDANIE URLOPÓW
//       pracownika
//       zespołu
//       powrót do poprzedniego menu

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class HolidaysReviewMenu1 extends MainMenu1 {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main() throws Exception {

        HolidaysReviewMenu1 holidaysReviewMenu = new HolidaysReviewMenu1();
        holidaysReviewMenu.menuOptionsDisplay();
        holidaysReviewMenu.userChooses();
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

    @Override
    public int userChooses() throws Exception {

        stdout.info("\n" + "Wybierz opcję od 1 do " + menuOptions.size() + "\n");

        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();

        switch (userChoice){
            case 1 :
                stdout.info("Przeglądanie urlopów pracownika - under construction" + "\n" + "\n");
                break;
            case 2 :
                stdout.info("Przeglądanie urlopów zespołu - under construction" + "\n" + "\n");
                break;
            case 3 :
                break;
        }
        return userChoice;
    }

}