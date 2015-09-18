package com.thoughtworks.biblioteca;

public class InvalidMenuOption {

    String message = "Invalid menu option";
    Printer printer = new Printer(System.out);

    public InvalidMenuOption(Printer printer) {
        this.printer = printer;
    }

    public void displayMessage() {
        printer.printMessage(message);
    }
}
