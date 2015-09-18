package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void shouldBeDifferentIfTheyHaveSameUserNameAndDifferentPassword() {
        User user1 = new User("123-1234","xhy","0","0","0");
        User user2 = new User("123-1234","xyz","0","0","0");
        assertNotEquals(user1, user2);
    }

    @Test
    public void shouldBeDifferentIfTheyHaveDifferentUserNameAndSamePassword() {
        User user1 = new User("123-1334","xyz","0","0","0");
        User user2 = new User("123-1234","xyz","0","0","0");
        assertNotEquals(user1, user2);
    }

    @Test
    public void shouldBeDifferentIfTheyHaveDifferentUserNameAndDifferentPassword() {
        User user1 = new User("123-1334","xhz","0","0","0");
        User user2 = new User("123-1234","xyz","0","0","0");
        assertNotEquals(user1, user2);
    }

    @Test
    public void shouldBeSameIfTheyHaveSameUserNameAndPassword() {
        User user1 = new User("123-1234","xyz","0","0","0");
        User user2 = new User("123-1234","xyz","0","0","0");
        assertEquals(user1, user2);
    }

    @Test
    public void shouldReturnTrueIfLibrarian() {
        User user1 = new User("123-4567","jhalaa","0","0","0");
        assertTrue(user1.isLibraian());
    }

    @Test
    public void shouldReturnFalseIfNotLibrarian() {
        User user1 = new User("123-4537","jhalaa","0","0","0");
        assertFalse(user1.isLibraian());
    }

    @Test
    public void shouldGetValidUserDetails() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        User user1 = new User("123-4537","jhalaa","jhalaa","jhalaachinoy@gmail.com","9535243238");
        user1.getMyDetails();
        assertEquals("jhalaa jhalaachinoy@gmail.com 9535243238\n", outputStream.toString());
    }

    @Test
    public void shouldReturnTheLibraryNumber() {
        User user1 = new User("123-4567","jhalaa","0","0","0");
        assertEquals(user1.toString(),"123-4567");
    }
}
