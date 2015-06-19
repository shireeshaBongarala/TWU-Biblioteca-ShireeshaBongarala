package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.HashMap;

public class EntryPoint {
    static HashMap<Book, User> bookUserHashMap;
    static HashMap<Movie, User> movieUserHashMap;
    static User user;

    public static void main(String args[]) {
        OutputHandler outputHandler = new OutputHandler(new PrintStream(System.out));
        InputHandler inputHandler = new InputHandler(System.in);
        Library library = new Library();
        Movies movies = new Movies(library.getAvailableMovieList());
        Books books = new Books(library.getAvailableBookList());
        bookUserHashMap = new HashMap<Book, User>();
        movieUserHashMap = new HashMap<Movie, User>();

        new BibliotecaApp(
                outputHandler, inputHandler, books, new ReturnItem(outputHandler, inputHandler, library),
                new CheckOutItem(outputHandler, inputHandler, library), movies).start();
    }
}
