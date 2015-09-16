package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    private static final String INVALID_LIBRARY_NUMBER ="0" ;
    private static final String INVALID_LIBRARY_NAME = "0" ;
    private final ArrayList<User> users;
    Scanner scanner;
    String libraryNumber;
    String password;

    public Login(ArrayList<User> users,Scanner scanner) {
        this.users = users;
        this.scanner = scanner;
    }

    public User acceptUserInput()  {
       libraryNumber = scanner.nextLine();
        password = scanner.nextLine();
        return new User(libraryNumber,password);
    }

    public User validateUser(User user) {
        if(users.contains(user))
            return user;
        return new User(INVALID_LIBRARY_NUMBER,INVALID_LIBRARY_NAME);
    }
}
