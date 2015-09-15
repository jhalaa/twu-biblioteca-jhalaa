package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void shouldHaveALibraryNumber() {
        User user = new User("123-1234");
        assertEquals("123-1234",user.getLibraryNumber());
    }
}
