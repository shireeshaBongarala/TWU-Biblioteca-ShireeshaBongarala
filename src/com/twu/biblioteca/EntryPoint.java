package com.twu.biblioteca;

import java.io.PrintStream;

public class EntryPoint {
    public static void main(String args[]) {
        OutputHandler outputHandler = new OutputHandler(new PrintStream(System.out));
        InputHandler inputHandler = new InputHandler(System.in);
        Library library = new Library();
        Movies movies = new Movies(library.getAvailableMovieList());
        Books books = new Books(library.getAvailableBookList());



        new BibliotecaApp(
                outputHandler, inputHandler,books,new ReturnItem(outputHandler,inputHandler,library),
                new CheckOutItem(outputHandler, inputHandler,library),movies).start();
    }
}
