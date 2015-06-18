package com.twu.biblioteca;

import static com.twu.biblioteca.Messages.*;

public class MainMenuForLoggedInUser extends MainMenuForLibrary {
    ReturnItem returnItem;

    MainMenuForLoggedInUser(OutputHandler outputHandler, InputHandler inputHandler,
                            CheckOutItem checkOutItem, Books books, BookListOption bookListOption,
                            MovieListOption movieListOption, Movies movies, Login login, ReturnItem returnItem) {
        super(outputHandler, inputHandler, checkOutItem, books, bookListOption, movieListOption, movies, login);
        this.returnItem = returnItem;
    }

    @Override
    public void start() {
        int choice;
        do {
            outputHandler.display(MAIN_MENU_FOR_LOGGEDIN_USER);
            choice = inputHandler.readInteger();

            switch (choice) {
                case 1:
                    bookListOption.performAction(books);
                    break;
                case 2:
                    movieListOption.performAction(movies);
                    break;
                case 3:
                    checkOutItem.checkOutBook();
                    break;
                case 4:
                    returnItem.returnBook();
                    break;
                case 5:
                    checkOutItem.checkOutMovie();
                    break;
                case 6:
                    returnItem.returnMovie();
                    break;
                case 7:
                    outputHandler.display(QUIT_MESSAGE);
                    break;
            }
        } while (choice != 7);

    }
}