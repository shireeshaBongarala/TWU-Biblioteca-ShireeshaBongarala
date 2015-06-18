package com.twu.biblioteca;


public class MovieListOption {
    OutputHandler outputHandler;
    CheckOutItem checkOutItem;

    MovieListOption(OutputHandler outputHandler, CheckOutItem checkOutItem) {
        this.checkOutItem = checkOutItem;
        this.outputHandler = outputHandler;
    }
    public void performAction(Movies movies) {
        outputHandler.display(movies);
    }
}
