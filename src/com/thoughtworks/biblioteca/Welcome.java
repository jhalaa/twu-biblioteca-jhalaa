package com.thoughtworks.biblioteca;

//displays the welcome message
public class Welcome {

    private String welcomeMessage;

    Welcome(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public void printMessage() {
        System.out.println(welcomeMessage);
    }
}
