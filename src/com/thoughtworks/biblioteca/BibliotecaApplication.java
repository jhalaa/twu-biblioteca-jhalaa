package com.thoughtworks.biblioteca;

import java.util.Scanner;

//set up biblioteca
public class BibliotecaApplication {

    private Configuration configuration = new Configuration();
    private Library library = configuration.start();
    private Menu menu = new Menu();
    private Dispatcher dispatcher = new Dispatcher(library,new Scanner(System.in));

    public void start() {
       menu.displayMenuOption();
        while(true) {
            dispatcher.run();
        }
    }

    public static void main(String[] args) {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();
        bibliotecaApplication.start();
    }
}
