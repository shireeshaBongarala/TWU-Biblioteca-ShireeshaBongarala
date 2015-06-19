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
        CheckOutItem checkOutItem = new CheckOutItem(outputHandler, inputHandler, library);
        bookUserHashMap = new HashMap<Book, User>();
        movieUserHashMap = new HashMap<Movie, User>();
        Authentication authentication = new Authentication();
        BookListOption bookListOption = new BookListOption(outputHandler, checkOutItem);
        MovieListOption movieListOption = new MovieListOption(outputHandler, checkOutItem);
        UserDetailsForLibrarian userDetailsForLibrarian = new UserDetailsForLibrarian(outputHandler);
        user = new User("visitor", "visitor@gmail.com", 123456, "000-0000", 0);
        new BibliotecaApp(
                outputHandler, inputHandler, books, new ReturnItem(outputHandler, inputHandler, library),
                checkOutItem, movies, authentication, bookListOption, movieListOption, userDetailsForLibrarian).start();
    }
}
