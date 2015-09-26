package com.thoughtworks.biblioteca;

import java.util.Scanner;

import static java.lang.System.exit;


//delegates the functionality based on the desicion to be taken.
public class Dispatcher {
    private static final User INVALID_USER = new User("0", "0", "0", "0", "0");
    private Scanner scanner;
    private BookLibrary bookLibrary;
    private MovieLibrary movieLibrary;
    private Printer printer = new Printer(System.out);
    private Validator validator;
    private User user;

    public Dispatcher(MovieLibrary movieLibrary, BookLibrary bookLibrary, Scanner scanner, Validator validator, User user) {
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
            displayBooks();
        }
        else if (input.equals("2")) {
            exit(0);
        }
        else if (input.equals("3")) {
            checkOutBook();
        }
        else if (input.equals("4")) {
            returnBook();
        }
        else if (input.equals("5")) {
            checkOutMovie();
        }
        else if (input.equals("6")) {
            displayMovie();
        }
        else if (input.equals("7")) {
            logout();
        }
        else if (input.equals("8")) {
            bookStatus();
        }
        else if (input.equals("9")) {
            userDetails();
        }
        else {
            displayInvalidMenuOption();
        }
    }

    private void displayBooks() {
        bookLibrary.displayContents();
    }

    private void displayInvalidMenuOption() {
        InvalidMenuOption invalidMenuOption = new InvalidMenuOption(printer);
        invalidMenuOption.displayMessage();
    }

    private void userDetails() {
        user.getMyDetails();
    }

    private void bookStatus() {
        if (user.equals(INVALID_USER)) {
            System.out.println("Enter login credentials");
            if (validator.callLogin()) {
                user = validator.myUser();
                if (!(user.isLibraian())) {
                    System.out.println("PERMISSION DENIED");
                } else {
                    bookLibrary.printStatus();
                }
            }
        } else {
            if (!(user.isLibraian())) {
                System.out.println("PERMISSION DENIED");
            } else {
                bookLibrary.printStatus();
            }
        }
    }

    private void logout() {
        user = INVALID_USER;
    }

    private void displayMovie() {
        movieLibrary.displayContents();
    }

    private void checkOutMovie() {
        String name = scanner.nextLine();
        movieLibrary.checkout(name);
    }

    private void returnBook() {
        if (user.equals(INVALID_USER)) {
            System.out.println("Enter login credentials");
            validUserReturnBook();
        } else {
            loggedInUserReturnsBook();
        }
    }

    private void loggedInUserReturnsBook() {
        System.out.println("enter book name");
        String bookName = scanner.nextLine();
        bookLibrary.returnBook(bookName, user);
    }

    private void validUserReturnBook() {
        if (validator.callLogin()) {
            user = validator.myUser();
            loggedInUserReturnsBook();
        }
    }

    private void checkOutBook() {
        if (user.equals(INVALID_USER)) {
            System.out.println("Enter login credentials");
            validUserChecksOutBook();
        }
        else {
            LoggedInUserChecksOutBook();
        }
    }

    private void LoggedInUserChecksOutBook() {
        System.out.println("Enter book name");
        String bookName = scanner.nextLine();
        bookLibrary.checkOutBook(bookName, user);
    }

    private void validUserChecksOutBook() {
        if (validator.callLogin()) {
            user = validator.myUser();
            LoggedInUserChecksOutBook();
        }
    }

    public User getUser() {
        return user;
    }
}