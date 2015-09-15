package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void shouldHaveALibraryNumber() {
        User user = new User("123-1234","xrr");
        assertEquals("123-1234",user.libraryNumber);
    }

    @Test
    public void shouldHaveAValidPassword() {
        User user = new User("123-1234","xyz");
        assertEquals("xyz",user.password);
    }

    @Test
    public void shouldBeSameIfTheyHaveSameUserNameAndPassword() {
        User user1 = new User("123-1234","xyz");
        User user2 = new User("123-1234","xyz");
        assertEquals(user1,user2);
    }
}
