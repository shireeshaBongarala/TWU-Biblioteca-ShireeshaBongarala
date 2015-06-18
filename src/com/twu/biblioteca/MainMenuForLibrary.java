package com.twu.biblioteca;

import static com.twu.biblioteca.Messages.*;

public class MainMenuForLibrary {
    InputHandler inputHandler;
    OutputHandler outputHandler;
    CheckOutItem checkOutItem;
    Books books;

    MainMenuForLibrary(OutputHandler outputHandler, InputHandler inputHandler,CheckOutItem checkOutItem,Books books) {
        this.outputHandler = outputHandler;
        this.inputHandler = inputHandler;
        this.checkOutItem = checkOutItem;
        this.books = books;
    }

    public void start() {
        int choice;
        outputHandler.display(Messages.MAIN_MENU_OPTIONS);
        choice = inputHandler.readInteger();

        if(choice == 1)
            bookListOption();
    }
    private void bookListOption() {
        promptForCheckingoutBooks();
        if (checkOutItem.isInterestedToCheckOut()) {
            outputHandler.display(ENTER_BOOK_NAME);
            checkOutItem.checkOutBook();
        }
    }
    private void promptForCheckingoutBooks() {
        outputHandler.display(books);
        outputHandler.display(PROMPT_USER_FOR_CHECKOUT_BOOK);
    }
}
