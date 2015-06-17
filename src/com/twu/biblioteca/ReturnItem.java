package com.twu.biblioteca;

import java.io.InputStream;
import java.util.Scanner;

import static com.twu.biblioteca.Messages.*;


public class ReturnItem {
    private final Scanner scanner;
    private Library library;

    public ReturnItem(InputStream in, Library library) {
        scanner = new Scanner(in);
        this.library = library;
    }

    public void getBookDetails(OutputHandler outputHandler) {
        String bookName = scanner.nextLine();
        if(library.additionToAvailableBookListIsSuccessful(bookName)) {
            outputHandler.display(SUCCESSFUL_BOOK_RETURN);
        }
        else {
            outputHandler.display(UNSUCCESSFUL_BOOK_RETURN);
        }
    }
}
