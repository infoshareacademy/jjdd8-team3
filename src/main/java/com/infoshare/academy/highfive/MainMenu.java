package com.infoshare.academy.highfive;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {

    String menuName = "MENU GLOWNE";

    //-----------------------------------------------
    //Wersja z opcjame wyboru jako arrayLista:
    List<String>menuOptions = new ArrayList<String>()

    //------------------------------------------------


    // ---------------------------------------------------------
// Wersja z opcjami zadeklarowanymi jako String []

//    String [] menuOptions = {"Planowanie urlopow", "Przegladanie urlopow", "Zarzadzanie pracownikami",
//                           "Konfiguracja programu"};
//    int menuLenght = menuOptions.length;
    //---------------------------------------------------------

    //String komunikat = menuName.get(1);

    protected static int userChoice (Scanner scanner, int menuLenght) {

        System.out.println(menuLenght + "Wybierz opcje:");
        System.out.println();
//        System.out.println("1 - Wyszukiwanie dni wolnych, 2 - Dodaj urlop, 3 - Anuluj urlop, 4 - Powrot do poprzedniego menu");
  //  }

//    public String[] menuOptions;
//    public String[] getMenuOptions() {
//        menuOptions = {"Planowanie urlopow", "Przegladanie urlopow", "Zarzadzanie pracownikami",
//                "Konfiguracja programu"}
//    }


}
