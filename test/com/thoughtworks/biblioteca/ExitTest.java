package com.thoughtworks.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class ExitTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void systemExitWithArbitraryStatusCode() {
        Exit exit1 = new Exit();
        exit.expectSystemExit();
        exit1.exitApplication();
    }
}
