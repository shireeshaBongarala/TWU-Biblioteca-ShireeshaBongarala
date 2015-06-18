package com.twu.biblioteca;

public class BookListOption {
    OutputHandler outputHandler;
    CheckOutItem checkOutItem;

    BookListOption(OutputHandler outputHandler, CheckOutItem checkOutItem) {
        this.checkOutItem = checkOutItem;
        this.outputHandler = outputHandler;
    }
    public void performAction(Books books) {
        outputHandler.display(books);
    }
}
