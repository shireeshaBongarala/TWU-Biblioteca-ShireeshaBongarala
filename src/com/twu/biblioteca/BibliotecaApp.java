package com.twu.biblioteca;

import static com.twu.biblioteca.Messages.*;

public class BibliotecaApp {
    int choice;
    OutputHandler outputHandler;
    InputHandler inputHandler;
    Books books;
    ReturnItem returnItem;
    CheckOutItem checkout;
    Library library;
    Movies movies;
    BookListOption bookListOption;
    MovieListOption movieListOption;
    Authentication authentication = new Authentication();
    Login login;

    public BibliotecaApp(OutputHandler outputHandler, InputHandler inputHandler, Books books,
                         ReturnItem returnItem, CheckOutItem checkOutItem, Movies movies) {
        this.outputHandler = outputHandler;
        this.inputHandler = inputHandler;
        this.returnItem = returnItem;
        this.checkout = checkOutItem;
        this.movies = movies;
        this.books = books;
        authentication = new Authentication();
        bookListOption = new BookListOption(outputHandler, checkout);
        movieListOption = new MovieListOption(outputHandler, checkOutItem);
        login = new Login(outputHandler, inputHandler, authentication);
    }

    public void start() {
        outputHandler.display(WELCOME_MESSAGE);
        MainMenuForLibrary mainMenuForLibrary = new MainMenuForLibrary(outputHandler, inputHandler,
                checkout, books, bookListOption, movieListOption, movies, login);
        MainMenuForLoggedInUser mainMenuForLoggedInUser = new MainMenuForLoggedInUser(outputHandler, inputHandler,
                checkout, books, bookListOption, movieListOption, movies, login,returnItem);

            if(authentication.getUserState()== 0)
                         mainMenuForLibrary.start();
            if(authentication.getUserState() == 1)
                        mainMenuForLoggedInUser.start();

    }
}
