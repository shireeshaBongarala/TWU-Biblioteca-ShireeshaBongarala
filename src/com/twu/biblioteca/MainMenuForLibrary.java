package com.twu.biblioteca;

import static com.twu.biblioteca.Messages.*;

public class MainMenuForLibrary {
    InputHandler inputHandler;
    OutputHandler outputHandler;
    CheckOutItem checkOutItem;
    Books books;
    Movies movies;
    BookListOption bookListOption;
    MovieListOption movieListOption;
    Login login;
    User user;

    MainMenuForLibrary(OutputHandler outputHandler, InputHandler inputHandler, CheckOutItem checkOutItem,
                       Books books, BookListOption bookListOption, MovieListOption movieListOption, Movies movies, Login login,User user) {
        this.outputHandler = outputHandler;
        this.inputHandler = inputHandler;
        this.checkOutItem = checkOutItem;
        this.books = books;
        this.movies = movies;
        this.bookListOption = bookListOption;
        this.movieListOption = movieListOption;
        this.login = login;
        this.user = user;
    }

    public void start() {
        int choice;
        do {
            outputHandler.display(MAIN_MENU_OPTIONS);
            choice = inputHandler.readInteger();

            switch (choice) {
                case 1:
                    bookListOption.performAction(books);
                    break;
                case 2:
                    movieListOption.performAction(movies);
                    break;
                case 3:
                   EntryPoint.user = login.performAction(user);
                    break;
                case 4:
                    outputHandler.display(QUIT_MESSAGE);
                    break;
            }
            if (choice == 3 && login.userState !=0)
                break;
        } while (choice != 4);
    }
}
