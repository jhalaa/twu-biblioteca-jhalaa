package com.thoughtworks.biblioteca;

//returns the menu
public class Menu {

    static String menuList = "1:List of books\t2:Exit\tCheckout";

    public String displayMenuOption() {
        return(menuList);
    }
}
