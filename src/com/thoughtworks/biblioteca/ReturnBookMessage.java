package com.thoughtworks.biblioteca;

public class ReturnBookMessage {
    private boolean isItSuccessful;

    public ReturnBookMessage(boolean isItSuccessful) {
        this.isItSuccessful = isItSuccessful;
    }

    public void displayMessage() {
        if(isItSuccessful)
            System.out.println("Thank you for returning the book.");
        else
            System.out.println("That is not a valid book to return.");
    }
}
