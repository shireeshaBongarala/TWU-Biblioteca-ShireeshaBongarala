package com.twu.biblioteca;

import static com.twu.biblioteca.EntryPoint.*;
import static com.twu.biblioteca.Messages.*;

public class BibliotecaApp {
    OutputHandler outputHandler;
    InputHandler inputHandler;
    Books books;
    ReturnItem returnItem;
    CheckOutItem checkout;
    Library library;
    Movies movies;
    BookListOption bookListOption;
    MovieListOption movieListOption;
    Authentication authentication;
    Login login;
    UserDetailsForLibrarian userDetailsForLibrarian;
    MainMenuForLibrary mainMenuForLibrary;
    MainMenuForLoggedInUser mainMenuForLoggedInUser;
    static int mainVariable = 0;


    public BibliotecaApp(OutputHandler outputHandler, InputHandler inputHandler, Books books,
                         ReturnItem returnItem, CheckOutItem checkOutItem, Movies movies,Authentication authentication,
                         BookListOption bookListOption,MovieListOption movieListOption,UserDetailsForLibrarian userDetailsForLibrarian,
                         Login login,MainMenuForLibrary mainMenuForLibrary,MainMenuForLoggedInUser mainMenuForLoggedInUser) {
        this.outputHandler = outputHandler;
        this.inputHandler = inputHandler;
        this.returnItem = returnItem;
        this.checkout = checkOutItem;
        this.movies = movies;
        this.books = books;
        this.authentication = authentication;
        this.bookListOption = bookListOption;
        this.movieListOption = movieListOption;
        this.userDetailsForLibrarian  = userDetailsForLibrarian;
        this.login = login;
        this.mainMenuForLibrary = mainMenuForLibrary;
        this.mainMenuForLoggedInUser = mainMenuForLoggedInUser;
    }

    public void start() {
        outputHandler.display(WELCOME_MESSAGE);
        MainMenuForLibrarian mainMenuForLibrarian = new MainMenuForLibrarian(outputHandler, inputHandler, bookListOption,
                books, movieListOption, movies, userDetailsForLibrarian);


          while(mainVariable == 0) {
        if (user.getUserType() == 0)
            mainMenuForLibrary.start();
        if (user.getUserType() == 1)
            mainMenuForLoggedInUser.start();
        if (user.getUserType() == 2)
            mainMenuForLibrarian.start();
         }
    }
}
