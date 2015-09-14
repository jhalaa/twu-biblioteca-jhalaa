package com.thoughtworks.biblioteca;

//displays the welcome message
public class Welcome {

    private String welcomeMessage;
    private Printer printer;

    Welcome(String welcomeMessage,Printer printer) {
        this.welcomeMessage = welcomeMessage;
        this.printer = printer;
    }

    public void printMessage() {
        printer.printMessage(welcomeMessage);
    }
}
