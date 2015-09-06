package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

//sets up biblioteca
public class BibliotecaMain {

    public static void main(String[] args) {

        Welcome welcome = new Welcome("Hello BookList lover!Welcome to biblioteca");
        welcome.printMessage();
        System.out.println("1:List of books\t2:Quit");

        ArrayList<Book> books =new ArrayList<Book>();
        books.add(new Book("Harry Potter", "JK Rowling", 1993));
        books.add(new Book("Da Vinci Code", "Dan Brown", 2007));
        BookList bookList = new BookList(books);
        Scanner s = new Scanner(System.in);
        Menu menu = new Menu();
        menu.displayMenuOption();
        while(true) {
            String inputOption;
            inputOption = s.nextLine();
            if (inputOption.equals("1"))
                bookList.printMessage();
            else if (inputOption.equals("2"))
                exit(0);
            else
                System.out.println("Invalid menu option");
        }
    }
}
