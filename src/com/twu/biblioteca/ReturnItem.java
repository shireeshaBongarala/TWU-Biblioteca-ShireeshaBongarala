package com.twu.biblioteca;

import java.io.InputStream;
import java.util.Scanner;

import static com.twu.biblioteca.Messages.*;


public class ReturnItem {
    private OutputHandler outputHandler;
    private InputHandler inputHandler;
    private Library library;

    public ReturnItem(OutputHandler outputHandler, InputHandler inputHandler, Library library) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.library = library;
    }

    public void returnBook() {
        String bookName = inputHandler.readLine();
        if (library.additionToAvailableBookListIsSuccessful(bookName)) {
            outputHandler.display(SUCCESSFUL_BOOK_RETURN);
        } else {
            outputHandler.display(UNSUCCESSFUL_BOOK_RETURN);
        }
    }


    public void returnMovie() {
        outputHandler.display(UNSUCCESSFUL_MOVIE_RETURN);
    }
}
