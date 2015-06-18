package com.twu.biblioteca;

public class MainMenuForLibrary {
    InputHandler inputHandler;
    OutputHandler outputHandler;
    CheckOutItem checkOutItem;
    Books books;
    BookListOption bookListOption;

    MainMenuForLibrary(OutputHandler outputHandler, InputHandler inputHandler, CheckOutItem checkOutItem, Books books, BookListOption bookListOption) {
        this.outputHandler = outputHandler;
        this.inputHandler = inputHandler;
        this.checkOutItem = checkOutItem;
        this.books = books;
        this.bookListOption = bookListOption;
    }

    public void start() {
        int choice;
        outputHandler.display(Messages.MAIN_MENU_OPTIONS);
        choice = inputHandler.readInteger();
        switch (choice) {
            case 1:
                bookListOption.performAction(books);
                break;
        }
    }
}