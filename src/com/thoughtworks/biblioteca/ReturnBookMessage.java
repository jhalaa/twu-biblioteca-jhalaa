package com.thoughtworks.biblioteca;

public class ReturnBookMessage {

    private Printer printer = new Printer(System.out);

    public ReturnBookMessage(Printer printer) {
        this.printer = printer;
    }

    public void displayAvailableMessage() {
        printer.printMessage("Thank you for returning the book.");
    }

    public void displayNotAvailableMessage() {
        printer.printMessage("That is not a valid book to return.");
    }
}
