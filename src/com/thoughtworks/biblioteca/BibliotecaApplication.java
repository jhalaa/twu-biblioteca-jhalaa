package com.thoughtworks.biblioteca;

import java.util.Scanner;

//set up biblioteca
public class BibliotecaApplication {

    private Configuration configuration = new Configuration();
    private BookLibrary bookLibrary = configuration.start();
    private Printer printer = new Printer(System.out);
    private Menu menu = new Menu(printer);
    private Dispatcher dispatcher = new Dispatcher(bookLibrary,new Scanner(System.in));

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
