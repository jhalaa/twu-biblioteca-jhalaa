package com.thoughtworks.biblioteca;

//returns the menu
public class Menu {

    private static String menuList = "\n1:List of books\t2:Exit\t3:Checkout Books\t4:Return\t5:Checkout Movies\t6:List of movies\t7:logout\t8:Books status\t9:user details";
    private Printer printer;

    public Menu(Printer printer) {
        this.printer = printer;
    }

    public void displayMenuOption() {
        printer.printMessage(menuList);
    }
}
