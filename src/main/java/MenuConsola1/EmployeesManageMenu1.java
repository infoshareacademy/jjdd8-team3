package MenuConsola1;

//    ZARZĄDZANIE PRACOWNIKAMI
//       wyświetl listę pracowników
//       dodaj pracownika
//       usun pracownika
//       powrót do poprzedniego menu

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeesManageMenu1 extends MainMenu1 {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main() throws Exception {

        EmployeesManageMenu1 employeesManageMenu = new EmployeesManageMenu1();
        employeesManageMenu.menuOptionsDisplay();
        employeesManageMenu.userChooses();
    }
    @Override
    public void menuOptionsDisplay() {

        String menuHeadline = "ZARZĄDZANIE PRACOWNIKAMI";

        menuOptions.add("Wyświetl listę pracowników");
        menuOptions.add("Dodaj pracownika");
        menuOptions.add("Usuń pracownika");
        menuOptions.add("Powrót do poprzedniego menu");

        stdout.info(menuHeadline + "\n" + "\n");

        for (int i = 0; i < menuOptions.size(); i++) {

            stdout.info((i + 1) + ": " + menuOptions.get(i) + "\n");
        }
    }

    @Override
    public int userChooses() throws Exception {

        stdout.info("\n" + "Wybierz opcję od 1 do " + menuOptions.size() + "\n");
        try {
            Scanner scanner = new Scanner(System.in);
;
            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    stdout.info("Wyświetl listę pracowników - under construction" + "\n" + "\n");
                    break;
                case 2:
                    stdout.info("Dodaj pracownika - under construction" + "\n" + "\n");
                    break;
                case 3:
                    stdout.info("Usuń pracownika - under construction" + "\n" + "\n");
                    break;
                case 4:
                    break;
                default:
                    stdout.info("Wrong number - try again");
                    userChooses();
            }
        } catch (InputMismatchException e){
                stdout.info("Not a number - try again");
                userChooses();
            }


        return userChoice;
    }
}