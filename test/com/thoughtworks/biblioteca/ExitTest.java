package com.thoughtworks.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class ExitTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void systemExitWithArbitraryStatusCode() {
        exit.expectSystemExit();
        System.exit(0);
    }

    @Test
    public void systemExitWithSelectedStatusCode0() {
        exit.expectSystemExitWithStatus(0);
        System.exit(0);
    }
}
