package com.twu.biblioteca;

import static com.twu.biblioteca.Messages.*;

public class MainMenuForLoggedInUser extends MainMenuForLibrary {
    ReturnItem returnItem;
    User user;

    MainMenuForLoggedInUser(OutputHandler outputHandler, InputHandler inputHandler,
                            CheckOutItem checkOutItem, Books books, BookListOption bookListOption,
                            MovieListOption movieListOption, Movies movies, Login login,User user, ReturnItem returnItem) {
        super(outputHandler, inputHandler, checkOutItem, books, bookListOption, movieListOption, movies, login,user);
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
                    outputHandler.display(ENTER_BOOK_NAME);
                    checkOutItem.checkOutBook();
                    break;
                case 4:
                    outputHandler.display(ENTER_BOOK_NAME_FOR_RETURNING);
                    returnItem.returnBook();
                    break;
                case 5:
                    outputHandler.display(ENTER_MOVIE_NAME);
                    checkOutItem.checkOutMovie();
                    break;
                case 6:
                    outputHandler.display(ENTER_MOVIE_NAME);
                    returnItem.returnMovie();
                    break;
                case 7:
                    outputHandler.display(EntryPoint.user);
                    break;
                case 8:
                    outputHandler.display(QUIT_MESSAGE);
                    break;
            }
        } while (choice != 8);
    }
}
