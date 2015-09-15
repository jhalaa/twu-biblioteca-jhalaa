package com.thoughtworks.biblioteca;

import java.util.Scanner;

//set up biblioteca
public class BibliotecaApplication {

    private ConfigurationOfBooks configurationOfBooks = new ConfigurationOfBooks();
    private ConfigurationOfMovies configurationOfMovies = new ConfigurationOfMovies();
    private BookLibrary bookLibrary = configurationOfBooks.start();
    private MovieLibrary movieLibrary = configurationOfMovies.start();
    private Printer printer = new Printer(System.out);
    private Menu menu = new Menu(printer);
    private Dispatcher dispatcher = new Dispatcher(movieLibrary, bookLibrary, new Scanner(System.in));

    public void start() {
        menu.displayMenuOption();
        while (true) {
            dispatcher.run();
        }
    }

    public static void main(String[] args) {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();
        bibliotecaApplication.start();
    }
}
