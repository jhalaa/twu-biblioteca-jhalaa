package com.thoughtworks.biblioteca;

//returns the menu
public class Menu {

    private static String menuList = "1:List of books\t2:Exit\t3:Checkout\t4:Return";
    private Printer printer;

    public Menu(Printer printer) {
        this.printer = printer;
    }

    public void displayMenuOption() {
        printer.printMessage(menuList);
    }
}
