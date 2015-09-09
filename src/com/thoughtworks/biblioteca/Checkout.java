package com.thoughtworks.biblioteca;

public class Checkout {

    private boolean hasBeenCheckedOut;

    Checkout(boolean hasBeenCheckedOut) {
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
