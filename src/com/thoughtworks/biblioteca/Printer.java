package com.thoughtworks.biblioteca;

import java.io.IOException;
import java.io.OutputStream;

public class Printer {

    OutputStream outputStream;
    public Printer(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void printMessage(String message) {
        try {
            message = message + "\n";
            outputStream.write(message.getBytes());
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
    }
}
