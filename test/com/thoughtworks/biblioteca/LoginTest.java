package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LoginTest {

    @Test
    public void shouldHaveLoginDetails() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("123-4567","jhalaa"));
        users.add(new User("123-4577","miffy"));
        users.add(new User("122-4517","xyz"));
        users.add(new User("123-2227","jksx"));
        Login login = new Login(users);
        assertEquals(users,login.users);

    }
}
