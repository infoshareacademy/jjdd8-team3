package com.infoshare.academy.highfive.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class CleanTerminal {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String checker = System.getProperty("os.name").toLowerCase();

    public static void cleanTerminal() {
        try {
            if (checker.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                stdout.info("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
