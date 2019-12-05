package MenuConsola;

//    ZARZĄDZANIE PRACOWNIKAMI
//       wyświetl listę pracowników
//       dodaj pracownika
//       usun pracownika
//       powrót do poprzedniego menu

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeesManageMenu extends MainMenu{
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main() throws Exception {

        EmployeesManageMenu holidaysPlanningMenu = new EmployeesManageMenu();
        holidaysPlanningMenu.menuOptionsDisplay();
        holidaysPlanningMenu.userChooses();
    }

    @Override
    public void menuOptionsDisplay() {

        String menuHeadline = "ZARZĄDZANIE PRACOWNIKAMI";

        menuOptions.add("Wyszukiwarka świąt");
        menuOptions.add("Wyświetl listę pracowników");
        menuOptions.add("Dodaj pracownika");
        menuOptions.add("Powrót do poprzedniego menu");

        stdout.info(menuHeadline + "\n" + "\n");

        for (int i = 0; i < menuOptions.size(); i++) {

            stdout.info((i + 1) + ": " + menuOptions.get(i) + "\n");
        }
    }

}
