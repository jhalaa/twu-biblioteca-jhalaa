package com.thoughtworks.biblioteca;

public class ReturnBookMessage {
    private boolean isItSuccessful;
    private Printer printer = new Printer(System.out);

    public ReturnBookMessage(boolean isItSuccessful, Printer printer) {
        this.isItSuccessful = isItSuccessful;
        this.printer = printer;
    }

    public void displayMessage() {
        if (isItSuccessful)
            printer.printMessage("Thank you for returning the book.");
        else
            printer.printMessage("That is not a valid book to return.");
    }
}
