package com.thoughtworks.biblioteca;

public class CheckoutMessage {

    private boolean hasBeenCheckedOut;
    private Printer printer;

    CheckoutMessage(boolean hasBeenCheckedOut, Printer printer) {
        this.hasBeenCheckedOut = hasBeenCheckedOut;
        this.printer = printer;
    }
    public void printMessage() {

        if(hasBeenCheckedOut) {
            printer.printMessage("Thank you! Enjoy the book");
        }
        else {
            printer.printMessage("That book is not available");
        }
    }

}
