package com.twu.biblioteca;

import static com.twu.biblioteca.Messages.*;

public class MovieListOption {
    OutputHandler outputHandler;
    CheckOutItem checkOutItem;

    MovieListOption(OutputHandler outputHandler, CheckOutItem checkOutItem) {
        this.checkOutItem = checkOutItem;
        this.outputHandler = outputHandler;
    }
    public void performAction(Movies movies) {
        outputHandler.display(movies);
        outputHandler.display(PROMPT_USER_FOR_CHECKOUT_MOVIE);
        if (checkOutItem.isInterestedToCheckOut()) {
            outputHandler.display(ENTER_MOVIE_NAME);
            checkOutItem.checkOutMovie();
        }
    }
}
