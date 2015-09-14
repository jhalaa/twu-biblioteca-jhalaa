package com.thoughtworks.biblioteca;

public class Printer {

    String message;
    public Printer(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
    }
}
