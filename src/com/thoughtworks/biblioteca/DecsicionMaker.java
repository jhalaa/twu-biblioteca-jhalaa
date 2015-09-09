package com.thoughtworks.biblioteca;

import java.util.Scanner;
//delegates the functionality based on the desicion to be taken.
public class DecsicionMaker {

    Scanner scanner ;
    Library library;

    public DecsicionMaker(Library library,Scanner scanner) {
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
                String bookname = scanner.nextLine();
                library.checkOutBook(bookname);
            } else if (input.equals("4")) {
                String bookname = scanner.nextLine();
                library.returnBook(bookname);
            }
            else {
                InvalidMenuOption invalidMenuOption = new InvalidMenuOption();
                invalidMenuOption.displayContents();
            }
       // }
    }
}