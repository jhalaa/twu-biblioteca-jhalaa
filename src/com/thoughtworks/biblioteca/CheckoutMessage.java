package com.thoughtworks.biblioteca;

public class CheckoutMessage {

    private boolean hasBeenCheckedOut;

    CheckoutMessage(boolean hasBeenCheckedOut) {
        this.hasBeenCheckedOut = hasBeenCheckedOut;
    }
    public void printMessage() {

        if(hasBeenCheckedOut) {
            System.out.println("Thank you! Enjoy the book");
        }
        else {
            System.out.println("That book is not available");
        }
    }

}
