package com.thoughtworks.biblioteca;

import java.util.Scanner;

import static java.lang.System.exit;


//delegates the functionality based on the desicion to be taken.
public class Dispatcher {
    private static final User INVALID_USER = new User("0","0") ;
    private Scanner scanner ;
    private BookLibrary bookLibrary;
    private MovieLibrary movieLibrary;
    private Printer printer = new Printer(System.out);
    private Validator validator;
    private User user;

    public Dispatcher(MovieLibrary movieLibrary, BookLibrary bookLibrary, Scanner scanner,Validator validator,User user) {
        this.movieLibrary = movieLibrary;
        this.bookLibrary = bookLibrary;
        this.scanner = scanner;
        this.validator = validator;
        this.user = user;
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
                if(user.equals(INVALID_USER)) {
                    System.out.println("Enter login credentials");
                    if (validator.callLogin()) {
                        user = validator.myUser();
                        System.out.println("Enter book name");
                        String bookName = scanner.nextLine();
                        bookLibrary.checkOutBook(bookName, user);
                    }
                }
                    else {
                        System.out.println("Enter book name");
                        String bookName = scanner.nextLine();
                        bookLibrary.checkOutBook(bookName,user);
                }
            }
            else if (input.equals("4")) {
                if(user.equals(INVALID_USER)) {
                    System.out.println("Enter login credentials");
                    if (validator.callLogin()) {
                        user = validator.myUser();
                        System.out.println("enter book name");
                        String bookName = scanner.nextLine();
                        bookLibrary.returnBook(bookName, user);
                    }
                }
                    else {
                        System.out.println("enter book name");
                        String bookName = scanner.nextLine();
                        bookLibrary.returnBook(bookName, user);
                    }
            }
            else if (input.equals("5")) {
                String name = scanner.nextLine();
                movieLibrary.checkout(name);
            }
            else if (input.equals("6")) {
                movieLibrary.displayContents();
            }
            else if (input.equals("7")) {
                user = INVALID_USER;
            }
            else if (input.equals("8")) {
                if(!(user.isLibraian())) {
                    System.out.println("PERMISSION DENIED");
                }
                else
                {
                    bookLibrary.printStatus();
                }
            }
            else {
                InvalidMenuOption invalidMenuOption = new InvalidMenuOption(printer);
                invalidMenuOption.displayMessage();
            }
    }

    public User getUser() {
        return user;
    }
}