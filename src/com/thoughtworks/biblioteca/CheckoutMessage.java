package com.thoughtworks.biblioteca;

public class CheckoutMessage {

    private Printer printer;

    CheckoutMessage(Printer printer) {
        this.printer = printer;
    }

    public void printSuccessfulMessage() {
        printer.printMessage("Thank you! Enjoy the book");
    }

    public void printUnsuccessfulMessage() {
        printer.printMessage("That book is not available");
    }
}
