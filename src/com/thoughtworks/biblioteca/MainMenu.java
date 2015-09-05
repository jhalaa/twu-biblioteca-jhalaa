package com.thoughtworks.biblioteca;

public class MainMenu {

    String option;
    public MainMenu(String option) {
        this.option = option;
    }

    public String displayMenu() {
        if(option.equals("1"))
            return "List of Books";
        return "Select a valid option!";
    }
}
