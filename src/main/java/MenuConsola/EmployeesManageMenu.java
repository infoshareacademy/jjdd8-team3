package MenuConsola;

//    ZARZĄDZANIE PRACOWNIKAMI
//       wyświetl listę pracowników
//       dodaj pracownika
//       usun pracownika
//       powrót do poprzedniego menu

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class EmployeesManageMenu extends MainMenu {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main() throws Exception {

        EmployeesManageMenu holidaysPlanningMenu = new EmployeesManageMenu();
        holidaysPlanningMenu.menuOptionsDisplay();
        holidaysPlanningMenu.userChooses();
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

        Scanner scanner = new Scanner(System.in);
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
        }
        return userChoice;
    }
}