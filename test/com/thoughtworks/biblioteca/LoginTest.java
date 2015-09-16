package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoginTest {

    @Test
    public void shouldValidateAValidUser() {
        ArrayList<User> users = new ArrayList<User>();
        Scanner scanner = new Scanner(System.in);
        users.add(new User("123-4567","jhalaa"));
        users.add(new User("123-4577","miffy"));
        users.add(new User("122-4517","xyz"));
        users.add(new User("123-2227","jksx"));
        Login login = new Login(users,scanner);
        User user1 = new User("123-4567", "jhalaa");
        assertEquals(login.validateUser(user1), user1);
    }



    @Test
    public void shouldInvalidateAnInvalidUser() {
        ArrayList<User> users = new ArrayList<User>();
        Scanner scanner = new Scanner(System.in);
        users.add(new User("123-4567","jhalaa"));
        users.add(new User("123-4577","miffy"));
        users.add(new User("122-4517","xyz"));
        users.add(new User("123-2227","jksx"));
        Login login = new Login(users,scanner);
        User user1 = new User("123-4568", "jhalaa");
        User user2 = new User("0","0");
        assertEquals(login.validateUser(user1),user2);
    }

    @Test
    public void shouldTakeInput() {
        String input = "jhbj\nklds\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("123-4567", "jhalaa"));
        users.add(new User("123-4577", "miffy"));
        users.add(new User("122-4517", "xyz"));
        users.add(new User("123-2227", "jksx"));
        Login login = new Login(users,new Scanner(inputStream));
        User user1 = login.acceptUserInput();
        assertEquals(new User("jhbj", "klds"), user1);
    }


}
