package com.twu.biblioteca;

import static com.twu.biblioteca.Messages.*;

public class MainMenuForLibrarian {
    OutputHandler outputHandler;
    InputHandler inputHandler;
    BookListOption bookListOption;
    Books books;
    Movies movies;
    MovieListOption movieListOption;
    UserDetailsForLibrarian userDetailsForLibrarian;

    public MainMenuForLibrarian(OutputHandler outputHandler,InputHandler inputHandler,BookListOption bookListOption,
                                Books books,MovieListOption movieListOption,Movies movies,UserDetailsForLibrarian userDetailsForLibrarian) {
        this.outputHandler = outputHandler;
        this.inputHandler = inputHandler;
        this.bookListOption = bookListOption;
        this.books = books;
        this.movies = movies;
        this.movieListOption = movieListOption;
        this.userDetailsForLibrarian = userDetailsForLibrarian;
    }

    public void start() {
        int choice;
        do {
        outputHandler.display(MAIN_MENU_FOR_LIBRARIAN);
         choice = inputHandler.readInteger();

        switch (choice) {
            case 1:
                bookListOption.performAction(books);
                break;
            case 2:
                movieListOption.performAction(movies);
                break;
            case 3:
                userDetailsForLibrarian.displayBookList();
                userDetailsForLibrarian.displayMovieList();
                break;
            case 4:
                outputHandler.display(EntryPoint.user);
                break;
            case 5:
                EntryPoint.user =  new User("visitor", "visitor@gmail.com", 123456, "000-0000", 0);
                outputHandler.display(QUIT_MESSAGE);
                break;
        }
    }while (choice != 5);
    }
}
