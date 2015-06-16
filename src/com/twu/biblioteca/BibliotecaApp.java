package com.twu.biblioteca;

import static com.twu.biblioteca.Messages.*;

public class BibliotecaApp {
    int choice;
    OutputHandler outputHandler;
    InputHandler inputHandler;
    Books books;
    ReturnBook returnBook;
    CheckOut checkout;
    Library library;
    Movies movies;

    public BibliotecaApp(OutputHandler outputHandler, InputHandler inputHandler, Books books, ReturnBook returnBook, CheckOut checkOut, Movies movies) {
        this.outputHandler = outputHandler;
        this.inputHandler = inputHandler;
        this.books = books;
        this.returnBook = returnBook;
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
                returnBook.getBookDetails(outputHandler);
            } else if (choice == 3) {
                promptForCheckingoutMovies();
                if(checkout.isInterestedToCheckOut()) {
                    outputHandler.display(ENTER_MOVIE_NAME);
                }
            } else if (choice == 4)
                outputHandler.display(QUIT_MESSAGE);

            else
                outputHandler.display(ERROR_MESSAGE);

        } while (choice != 4);
    }

    private void promptForCheckingoutBooks() {
        outputHandler.display(books);
        outputHandler.display(PROMPT_USER_FOR_CHECKOUT_BOOK);
    }

    private void promptForCheckingoutMovies() {
        outputHandler.display(movies);
        
    }
}
