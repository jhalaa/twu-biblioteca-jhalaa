package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UserTest {

    @Test
    public void shouldBeDifferentIfTheyHaveSameUserNameAndDifferentPassword() {
        User user1 = new User("123-1234","xhy");
        User user2 = new User("123-1234","xyz");
        assertNotEquals(user1, user2);
    }

    @Test
    public void shouldBeDifferentIfTheyHaveDifferentUserNameAndSamePassword() {
        User user1 = new User("123-1334","xyz");
        User user2 = new User("123-1234","xyz");
        assertNotEquals(user1, user2);
    }

    @Test
    public void shouldBeDifferentIfTheyHaveDifferentUserNameAndDifferentPassword() {
        User user1 = new User("123-1334","xhz");
        User user2 = new User("123-1234","xyz");
        assertNotEquals(user1, user2);
    }

    @Test
    public void shouldBeSameIfTheyHaveSameUserNameAndPassword() {
        User user1 = new User("123-1234","xyz");
        User user2 = new User("123-1234","xyz");
        assertEquals(user1,user2);
    }
}
