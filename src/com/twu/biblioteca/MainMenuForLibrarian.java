package com.twu.biblioteca;

import static com.twu.biblioteca.Messages.*;

public class MainMenuForLibrarian {
    OutputHandler outputHandler;
    InputHandler inputHandler;
    BookListOption bookListOption;
    Books books;

    public MainMenuForLibrarian(OutputHandler outputHandler,InputHandler inputHandler,BookListOption bookListOption,Books books) {
        this.outputHandler = outputHandler;
        this.inputHandler = inputHandler;
        this.bookListOption = bookListOption;
        this.books = books;
    }

    public void start() {
        outputHandler.display(MAIN_MENU_FOR_LIBRARIAN);
        int choice = inputHandler.readInteger();

        switch (choice) {
            case 1:
                bookListOption.performAction(books);
                break;
        }
    }
}
