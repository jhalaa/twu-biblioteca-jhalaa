package com.thoughtworks.biblioteca;

import java.util.Scanner;
//delegates the functionality based on the desicion to be taken.
public class DecisionMaker {

    Scanner scanner ;
    Library library;

    public DecisionMaker(Library library, Scanner scanner) {
        this.library = library;
        this.scanner = scanner;
    }

    public void start() {
        String input;
       // while (true) {
            input = scanner.nextLine();
            if (input.equals("1")) {
                library.displayContents();
            }
            else if (input.equals("2")) {
                Exit exit = new Exit();
                exit.exitApplication();
            }
            else if (input.equals("3")) {
                String bookName = scanner.nextLine();
                library.checkOutBook(bookName);
            } else if (input.equals("4")) {
                String bookName = scanner.nextLine();
                library.returnBook(bookName);
            }
            else {
                InvalidMenuOption invalidMenuOption = new InvalidMenuOption();
                invalidMenuOption.displayContents();
            }
       // }
    }
}