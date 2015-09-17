package com.thoughtworks.biblioteca;

public class User {
    private static final User LIBRARIAN =new User("123-4567","jhalaa") ;
    private String libraryNumber;
    private String password;

    public User(String libraryNumber ,String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    @Override
    public boolean equals(Object object) {
        User user = (User)object;
        if(this.libraryNumber.equals(user.libraryNumber) && this.password.equals(user.password))
            return true;
        return false;
    }

    public boolean isLibraian() {
        if(this.equals(LIBRARIAN))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return libraryNumber;
    }
}
