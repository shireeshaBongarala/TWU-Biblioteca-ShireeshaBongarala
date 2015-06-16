package com.twu.biblioteca;

import static com.twu.biblioteca.Messages.SUCCESSFUL_BOOK_CHECKOUT;
import static com.twu.biblioteca.Messages.THAT_BOOK_IS_NOT_AVAILABLE;
import static com.twu.biblioteca.Messages.THAT_MOVIE_IS_NOT_AVAILABLE;

public class CheckOut {
OutputHandler outputHandler;
    InputHandler inputHandler;
    Library library;

    CheckOut(OutputHandler OutputHandler, InputHandler inputHandler,Library library) {
        this.outputHandler = OutputHandler;
        this.inputHandler = inputHandler;
        this.library = library;
    }

    public boolean isInterestedToCheckOut() {
        inputHandler.readLine();
        if (inputHandler.readLine().equals("y")) return true;
        return false;
    }

    public void checkOutBook() {
        String bookName = inputHandler.readLine();
        if (library.additionToCheckedOutBookListIsSuccessful(bookName)) {
            outputHandler.display(SUCCESSFUL_BOOK_CHECKOUT);
        } else
            outputHandler.display(THAT_BOOK_IS_NOT_AVAILABLE);
    }

    public void checkOutMovie() {
        String movieName = inputHandler.readLine();
        if(library.additionToCheckedOutMovieListIsSuccessful(movieName)) {
            outputHandler.display(Messages.SUCCESSFUL_MOVIE_CHECKOUT);
        }
    }
}
