package com.thoughtworks.biblioteca;

import java.util.Scanner;

import static java.lang.System.exit;

//delegates the functionality based on the desicion to be taken.
public class Dispatcher {
    Scanner scanner ;
    Library library;
    Printer printer = new Printer(System.out);
    public Dispatcher(Library library, Scanner scanner) {
        this.library = library;
        this.scanner = scanner;
    }

    public void run() {
            String input;
            input = scanner.nextLine();
            if (input.equals("1")) {
                library.displayContents();
            }
            else if (input.equals("2")) {
               exit(0);
            }
            else if (input.equals("3")) {
                String bookName = scanner.nextLine();
                library.checkOutBook(bookName);
            } else if (input.equals("4")) {
                String bookName = scanner.nextLine();
                library.returnBook(bookName);
            }
            else {
                InvalidMenuOption invalidMenuOption = new InvalidMenuOption(printer);
                invalidMenuOption.displayMessage();
            }
    }
}