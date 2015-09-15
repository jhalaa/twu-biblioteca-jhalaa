package com.thoughtworks.biblioteca;

public class User {
    private String libraryNumber;
    private String password;

    public User(String libraryNumber ,String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    @Override
    public boolean equals(Object object) {
        User user = (User)object;
        if(this.libraryNumber == user.libraryNumber && this.password == user.password)
            return true;
        return false;
    }
}