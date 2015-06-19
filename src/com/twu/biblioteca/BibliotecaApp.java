package com.twu.biblioteca;

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
    Authentication authentication = new Authentication();
    Login login;
    UserDetailsForLibrarian userDetailsForLibrarian;
    static int mainVariable = 0;


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
        userDetailsForLibrarian = new UserDetailsForLibrarian(outputHandler);
        EntryPoint.user = new User("visitor", "visitor@gmail.com", 123456, "000-0000", 0);
    }

    public void start() {
        outputHandler.display(WELCOME_MESSAGE);
        MainMenuForLibrary mainMenuForLibrary = new MainMenuForLibrary(outputHandler, inputHandler,
                checkout, books, bookListOption, movieListOption, movies, login, EntryPoint.user);
        MainMenuForLoggedInUser mainMenuForLoggedInUser = new MainMenuForLoggedInUser(outputHandler, inputHandler,
                checkout, books, bookListOption, movieListOption, movies, login, EntryPoint.user, returnItem);
        MainMenuForLibrarian mainMenuForLibrarian = new MainMenuForLibrarian(outputHandler, inputHandler, bookListOption,
                books, movieListOption, movies, userDetailsForLibrarian);


        //  while(mainVariable == 0) {
        if (EntryPoint.user.getUserType() == 0)
            mainMenuForLibrary.start();
        if (EntryPoint.user.getUserType() == 1)
            mainMenuForLoggedInUser.start();
        if (EntryPoint.user.getUserType() == 2)
            mainMenuForLibrarian.start();
        // }
    }
}
