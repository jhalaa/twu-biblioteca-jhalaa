package com.thoughtworks.biblioteca;

public class InvalidMenuOption implements Operation{
    @Override
    public void displayContents() {
        System.out.println("Invalid menu option");
    }
}
