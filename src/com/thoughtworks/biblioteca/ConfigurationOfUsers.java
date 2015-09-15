package com.thoughtworks.biblioteca;

import java.util.AbstractList;
import java.util.ArrayList;

public class ConfigurationOfUsers {

    private ArrayList<User> users = new ArrayList<User>();

    public ArrayList<User> returnUserList() {
        users.add(new User("123-4567","jhalaa"));
        users.add(new User("123-4577","miffy"));
        users.add(new User("122-4517","xyz"));
        users.add(new User("123-2227","jksx"));
        return users;
    }
}
