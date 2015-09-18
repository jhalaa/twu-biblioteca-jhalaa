package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class ConfigurationOfUsers {

    private ArrayList<User> users = new ArrayList<User>();

    public ArrayList<User> returnUserList() {
        users.add(new User("123-4567", "jhalaa", "jhalaa", "jhalaachinoy@gmail.com", "9535243238"));
        users.add(new User("123-4577", "miffy", "sophia", "sopiag@gmail.com", "9654265436"));
        users.add(new User("222-2222", "got", "jon Snow", "jonsnow@gmail.com", "3456745676"));
        users.add(new User("333-3333", "pll", "Alison", "alisond@gmail.com", "5695369770"));
        return users;
    }
}
