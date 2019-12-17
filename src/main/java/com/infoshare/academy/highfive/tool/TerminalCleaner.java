package com.infoshare.academy.highfive.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class TerminalCleaner {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String OS_CHECKER = System.getProperty("os.name").toLowerCase();

    private TerminalCleaner() {
        throw new IllegalStateException("Utility Terminal cleaner class");
    }

    public static void cleanTerminal() {
        try {
            if (OS_CHECKER.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                stdout.info("\033[H\033[2J");
                System.out.flush();
            }
        } catch (InterruptedException | IOException e) {
            stdout.info("Error in action of terminal clean!\n", e);
        }
    }

}
