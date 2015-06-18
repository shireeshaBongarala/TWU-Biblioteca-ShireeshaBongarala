package com.twu.biblioteca;

public class MainMenuForLibrary {
    InputHandler inputHandler;
    OutputHandler outputHandler;
    CheckOutItem checkOutItem;
    Books books;
    Movies movies;
    BookListOption bookListOption;
    MovieListOption movieListOption;

    MainMenuForLibrary(OutputHandler outputHandler, InputHandler inputHandler, CheckOutItem checkOutItem, Books books, BookListOption bookListOption,MovieListOption movieListOption,Movies movies) {
        this.outputHandler = outputHandler;
        this.inputHandler = inputHandler;
        this.checkOutItem = checkOutItem;
        this.books = books;
        this.movies = movies;
        this.bookListOption = bookListOption;
        this.movieListOption = movieListOption;
    }

    public void start() {
        int choice;
        outputHandler.display(Messages.MAIN_MENU_OPTIONS);
        choice = inputHandler.readInteger();
        switch (choice) {
            case 1:
                bookListOption.performAction(books);
                break;
            case 2:
                movieListOption.performAction(movies);
                break;
        }
    }
}