package com.thoughtworks.biblioteca;

import java.util.Scanner;

//set up biblioteca
public class BibliotecaApplication {

    private Configuration configuration = new Configuration();
    private Library library = configuration.start();
    private Menu menu = new Menu();
    private DecsicionMaker decsicionMaker = new DecsicionMaker(library,new Scanner(System.in));
    public void start() {
        System.out.println(menu.displayMenuOption());
        decsicionMaker.start();
    }
}
