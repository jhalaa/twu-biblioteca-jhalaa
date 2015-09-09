package com.thoughtworks.biblioteca;

import java.util.Scanner;

//set up biblioteca
public class BibliotecaApplication {

    private Configuration configuration = new Configuration();
    private Library library = configuration.start();
    private Menu menu = new Menu();
    private Dispatcher dispatcher = new Dispatcher(library,new Scanner(System.in));

    public void start() {
        System.out.println(menu.displayMenuOption());
        while(true) {
            dispatcher.run();
        }
    }
}
