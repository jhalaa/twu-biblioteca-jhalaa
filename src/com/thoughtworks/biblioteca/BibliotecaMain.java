package com.thoughtworks.biblioteca;

import java.util.Scanner;

import static java.lang.System.exit;

//delegation of biblioteca operations
public class BibliotecaMain {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        BookList bookList = configuration.start();
        Menu menu = new Menu();
        System.out.println(menu.displayMenuOption());
        Scanner s = new Scanner(System.in);
        while(true) {
            String inputOption;
            inputOption = s.nextLine();
            if (inputOption.equals("1"))
                bookList.printMessage();
            else if (inputOption.equals("2"))
                exit(0);
            else
                System.out.println("Invalid menu option");
        }
    }
}
