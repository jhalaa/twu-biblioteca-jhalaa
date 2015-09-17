package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

//set up biblioteca
public class BibliotecaApplication {

    private static final String INVALID_LIBRARY_NUMBER ="0" ;
    private static final String INVALID_PASSWORD = "0";
    private static final String UNKNOWN_NAME = "0";
    private static final String UNKNOWN_EMAIL = "0";
    private static final String UNKNOWN_PHONENUMBER = "0" ;
    private ConfigurationOfBooks configurationOfBooks = new ConfigurationOfBooks();
    private ConfigurationOfMovies configurationOfMovies = new ConfigurationOfMovies();
    private BookLibrary bookLibrary = configurationOfBooks.start();
    private MovieLibrary movieLibrary = configurationOfMovies.start();
    private Printer printer = new Printer(System.out);
    private Menu menu = new Menu(printer);
    private ConfigurationOfUsers configurationOfUsers = new ConfigurationOfUsers();
    private User user = new User(INVALID_LIBRARY_NUMBER, INVALID_PASSWORD,UNKNOWN_NAME,UNKNOWN_EMAIL,UNKNOWN_PHONENUMBER);
    private Scanner scanner = new Scanner(System.in);
    private Login login = new Login(configurationOfUsers.returnUserList(), scanner);
    private Validator validator = new Validator(login);
    private Dispatcher dispatcher = new Dispatcher(movieLibrary, bookLibrary, new Scanner(System.in), validator, user);

    public void start() {

        while (true) {
            menu.displayMenuOption();
            dispatcher.run();
        }
    }

    public static void main(String[] args) {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();
        bibliotecaApplication.start();
    }
}
