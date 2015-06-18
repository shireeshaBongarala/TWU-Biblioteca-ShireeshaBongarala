package com.twu.biblioteca;

import static com.twu.biblioteca.Messages.MAIN_MENU_FOR_LOGGEDIN_USER;
import static com.twu.biblioteca.Messages.MAIN_MENU_OPTIONS;
import static com.twu.biblioteca.Messages.QUIT_MESSAGE;

public class MainMenuForLoggedInUser  extends MainMenuForLibrary {
    MainMenuForLoggedInUser(OutputHandler outputHandler, InputHandler inputHandler,
                            CheckOutItem checkOutItem, Books books, BookListOption bookListOption, MovieListOption movieListOption, Movies movies, Login login) {
        super(outputHandler, inputHandler, checkOutItem, books, bookListOption, movieListOption, movies, login);
    }

    @Override
    public void start() {
        outputHandler.display(MAIN_MENU_FOR_LOGGEDIN_USER);
    }
}