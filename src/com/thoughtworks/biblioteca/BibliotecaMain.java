package com.thoughtworks.biblioteca;

import java.util.Scanner;

//delegation of biblioteca operations
public class BibliotecaMain {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        Library library = configuration.start();
        Menu menu = new Menu();
        System.out.println(menu.displayMenuOption());
        Scanner s = new Scanner(System.in);
        while(true) {
            String inputOption;
            inputOption = s.nextLine();
            if (inputOption.equals("1"))
                library.displayContents();
            else if (inputOption.equals("2")) {
                Exit exit = new Exit();
                exit.displayContents();
            }
            else if(inputOption.equals("3")) {
                library.checkOutContent(new Book("Harry Potter","JK Rowling", 1993));
                library.displayContents();
            }
            else
                System.out.println("Invalid menu option");
        }
    }
}
