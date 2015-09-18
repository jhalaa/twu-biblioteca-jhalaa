package com.thoughtworks.biblioteca;

public class Validator {
    private static final String INVALID_LIBRARY_NUMBER = "0";
    private static final String INVALID_PASSWORD = "0";
    private static final String UNKNOWN_NAME = "0";
    private static final String UNKNOWN_EMAIL = "0";
    private static final String UNKNOWN_PHONENUMBER = "0";
    private Login login;
    private User myUser;

    public Validator(Login login) {
        this.login = login;
    }

    public boolean callLogin() {
        myUser = login.validateUser(login.acceptUserInput());
        if (!(myUser.equals(new User(INVALID_LIBRARY_NUMBER, INVALID_PASSWORD, UNKNOWN_NAME, UNKNOWN_EMAIL, UNKNOWN_PHONENUMBER))))
            return true;
        else {
            System.out.println("enter valid credentials");
            return false;
        }
    }

    public User myUser() {
        return myUser;
    }
}
