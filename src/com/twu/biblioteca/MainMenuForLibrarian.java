package com.twu.biblioteca;

import static com.twu.biblioteca.Messages.*;

public class MainMenuForLibrarian {
    OutputHandler outputHandler;
    InputHandler inputHandler;
    BookListOption bookListOption;
    Books books;
    Movies movies;
    MovieListOption movieListOption;

    public MainMenuForLibrarian(OutputHandler outputHandler,InputHandler inputHandler,BookListOption bookListOption,Books books,MovieListOption movieListOption,Movies movies) {
        this.outputHandler = outputHandler;
        this.inputHandler = inputHandler;
        this.bookListOption = bookListOption;
        this.books = books;
        this.movies = movies;
        this.movieListOption = movieListOption;
    }

    public void start() {
        outputHandler.display(MAIN_MENU_FOR_LIBRARIAN);
        int choice = inputHandler.readInteger();

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
