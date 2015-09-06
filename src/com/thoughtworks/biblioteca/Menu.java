package com.thoughtworks.biblioteca;

//returns the menu option selected
public class Menu {

    String option;
    public Menu(String option) {
        this.option = option;
    }

    public boolean returnsMenuOptionSelected() {
        if(option.equals("1"))
            return true;
        return false;
    }
}
