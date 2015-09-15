package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginTest {

    @Test
    public void shouldHaveLoginDetails() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("123-4567","jhalaa"));
        users.add(new User("123-4577","miffy"));
        users.add(new User("122-4517","xyz"));
        users.add(new User("123-2227","jksx"));
        Login login = new Login(users);
        assertEquals(users, login.users);
    }

    @Test
    public void shouldValidateAValidUser() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("123-4567","jhalaa"));
        users.add(new User("123-4577","miffy"));
        users.add(new User("122-4517","xyz"));
        users.add(new User("123-2227","jksx"));
        Login login = new Login(users);
        User user1 = new User("123-4567", "jhalaa");
        assertTrue(login.validateUser(user1));
    }

    @Test
    public void shouldInvalidateAnInvalidUser() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("123-4567","jhalaa"));
        users.add(new User("123-4577","miffy"));
        users.add(new User("122-4517","xyz"));
        users.add(new User("123-2227","jksx"));
        Login login = new Login(users);
        User user1 = new User("123-4568", "jhalaa");
        assertFalse(login.validateUser(user1));
    }


}
