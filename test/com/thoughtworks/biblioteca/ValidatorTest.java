package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidatorTest {

    @Test
    public void shouldCallDispatcherOnValidLogin() {
       String input = "123-4567\nlaa\n";
       ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
       Scanner scanner = new Scanner(inputStream);
       ConfigurationOfUsers configurationOfUsers = new ConfigurationOfUsers();
       Login login = new Login(configurationOfUsers.returnUserList(),scanner);
       Validator validator = new Validator(login);
       assertFalse(validator.callLogin());
    }

    @Test
    public void shouldNotCallDispatcherOnInvalidLogin() {
        String input = "123-4567\njhalaa\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);
        ConfigurationOfUsers configurationOfUsers = new ConfigurationOfUsers();
        Login login = new Login(configurationOfUsers.returnUserList(),scanner);
        Validator validator = new Validator(login);
        assertTrue(validator.callLogin());

    }

    @Test
    public void shouldReturnMyCurrentUser() {
        String input = "123-4567\njhalaa\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);
        ConfigurationOfUsers configurationOfUsers = new ConfigurationOfUsers();
        Login login = new Login(configurationOfUsers.returnUserList(),scanner);
        Validator validator = new Validator(login);
        validator.callLogin();
        User user = new User("123-4567","jhalaa","0","0","0");
        assertEquals(validator.myUser(),user);
    }
}
