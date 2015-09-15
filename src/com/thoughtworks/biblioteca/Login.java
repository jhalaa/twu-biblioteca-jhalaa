package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class Login {

    public final ArrayList<User> users;

    public Login(ArrayList<User> users) {
        this.users = users;
    }

    public boolean validateUser(User user) {
        if(users.contains(user))
            return true;
        return false;
    }
}
