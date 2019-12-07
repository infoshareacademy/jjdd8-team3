package MenuConsola;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuBuilder {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    protected static int userChoice;

    static List<String> menuOptions = new ArrayList<>();

    protected void menuDisplay() {

    stdout.info(menuOptions.get(0) + "\n\n" + "Choose an option and type number from 0 to " + (menuOptions.size() - 1) + "\n\n");

        for (int i = 1; i < menuOptions.size(); i++) {

            stdout.info((i) + ": " + menuOptions.get(i) + "\n");
        }
//        menuOptions.clear();
        stdout.info("\n" + "0: Exit" + "\n");
    }


    protected int getUserChoice() {

        try {

            Scanner scanner = new Scanner(System.in);
            scanner.useRadix(menuOptions.size());
            userChoice = scanner.nextInt();

        } catch (InputMismatchException e) {
            stdout.info("Wrong input - try again" + "\n");
            getUserChoice();
        }
        return userChoice;
    }
}

