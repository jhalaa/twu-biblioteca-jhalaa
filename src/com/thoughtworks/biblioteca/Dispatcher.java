package com.thoughtworks.biblioteca;

import java.util.Scanner;

import static java.lang.System.exit;

//delegates the functionality based on the desicion to be taken.
public class Dispatcher {
    Scanner scanner ;
    BookLibrary bookLibrary;
    MovieLibrary movieLibrary;
    Printer printer = new Printer(System.out);
    Validator validator;

    public Dispatcher(MovieLibrary movieLibrary, BookLibrary bookLibrary, Scanner scanner,Validator validator) {
        this.movieLibrary = movieLibrary;
        this.bookLibrary = bookLibrary;
        this.scanner = scanner;
        this.validator = validator;
    }

    public void run() {
            String input;

            input = scanner.nextLine();
            if (input.equals("1")) {
                bookLibrary.displayContents();
            }
            else if (input.equals("2")) {
               exit(0);
            }
            else if (input.equals("3")) {
                System.out.println("Enter login credentials");
                if(validator.callLogin()) {
                    System.out.println("Enter book name");
                    String bookName = scanner.nextLine();
                    bookLibrary.checkOutBook(bookName);
                }
            }
            else if (input.equals("4")) {
                System.out.println("Enter login credentials");
                if (validator.callLogin()) {
                    System.out.println("enter book name");
                    String bookName = scanner.nextLine();
                    bookLibrary.returnBook(bookName);
                }
            }
            else if (input.equals("5")) {
                String name = scanner.nextLine();
                movieLibrary.checkout(name);
            }
            else if (input.equals("6")) {
                movieLibrary.displayContents();
            }
            else {
                InvalidMenuOption invalidMenuOption = new InvalidMenuOption(printer);
                invalidMenuOption.displayMessage();
            }
    }
}