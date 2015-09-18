package com.thoughtworks.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayInputStream;

public class BibliotecaApplicationTest {

    @Rule
    public ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldCallDispatcherWhenStartIsCalled() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("2".getBytes());
        System.setIn(inputStream);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();
        exit.expectSystemExitWithStatus(0);

        bibliotecaApplication.start();
    }


}
