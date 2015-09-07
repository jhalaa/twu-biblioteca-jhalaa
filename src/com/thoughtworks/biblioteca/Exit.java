package com.thoughtworks.biblioteca;

import static java.lang.System.exit;

public class Exit implements Operation{

    @Override
    public void displayContents() {
        exit(0);
    }
}
