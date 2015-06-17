package com.twu.biblioteca;

import static com.twu.biblioteca.Messages.*;

public class BibliotecaApp {
    int choice;
    OutputHandler outputHandler;
    InputHandler inputHandler;
    Books books;
    ReturnItem returnItem;
    CheckOut checkout;
    Library library;
    Movies movies;

    public BibliotecaApp(OutputHandler outputHandler, InputHandler inputHandler, Books books, ReturnItem returnItem, CheckOut checkOut, Movies movies) {
        this.outputHandler = outputHandler;
        this.inputHandler = inputHandler;
        this.books = books;
        this.returnItem = returnItem;
        this.checkout = checkOut;
        this.movies = movies;
    }

    public void start() {
        do {
            outputHandler.display(MENU_OPTIONS);
            choice = inputHandler.readInteger();
            if (choice == 1) {
                promptForCheckingoutBooks();
                if (checkout.isInterestedToCheckOut()) {
                    outputHandler.display(ENTER_BOOK_NAME);
                    checkout.checkOutBook();
                }
            } else if (choice == 2) {
                outputHandler.display(ENTER_BOOK_NAME_FOR_RETURNING);
                returnItem.returnBook();
            } else if (choice == 3) {
                promptForCheckingoutMovies();
                if(checkout.isInterestedToCheckOut()) {
                    outputHandler.display(ENTER_MOVIE_NAME);
                    checkout.checkOutMovie();
                }
            } else if (choice == 5)
                outputHandler.display(QUIT_MESSAGE);

            else
                outputHandler.display(ERROR_MESSAGE);

        } while (choice != 5);
    }

    private void promptForCheckingoutBooks() {
        outputHandler.display(books);
        outputHandler.display(PROMPT_USER_FOR_CHECKOUT_BOOK);
    }

    private void promptForCheckingoutMovies() {
        outputHandler.display(movies);
        outputHandler.display(PROMPT_USER_FOR_CHECKOUT_MOVIE);
    }
}
