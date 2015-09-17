package com.thoughtworks.biblioteca;

public class CheckoutMessage {

    private Printer printer;

    CheckoutMessage(Printer printer) {
        this.printer = printer;
    }

    public void printSuccessfulBookCheckoutMessage() {
        printer.printMessage("Thank you! Enjoy the book");
    }

    public void printUnsuccessfulBookCheckoutMessage() {
        printer.printMessage("That book is not available");
    }

    public void printSuccessfulMovieCheckoutMessage() {
        printer.printMessage("Thank you! Enjoy the movie");
    }

    public void printUnsuccessfulMovieCheckoutMessage() {
        printer.printMessage("That movie is not available");
    }
}
