package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

//sets up biblioteca
public class BibliotecaMain {

    public static void main(String[] args) {

        Welcome welcome = new Welcome("Hello BookList lover!Welcome to biblioteca");
        welcome.printMessage();
        System.out.println("1:List of books\t");

        ArrayList<Book> books =new ArrayList<Book>();
        books.add(new Book("Harry Potter", "JK Rowling", 1993));
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007));
        BookList bookList = new BookList(books);
        Scanner s = new Scanner(System.in);
        String inputOption;
        inputOption = s.nextLine();
        Menu menu = new Menu(inputOption);
        if(menu.returnsMenuOptionSelected())
            bookList.printMessage();
        else
            System.out.println("Invalid menu option");
    }
}
