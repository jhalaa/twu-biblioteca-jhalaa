package com.thoughtworks.biblioteca;

//returns the menu
public class Menu {

    private static String menuList = "1:List of books\t2:Exit\t3:Checkout\t4:Return";

    public void displayMenuOption() {
        System.out.println(menuList);
    }
}
