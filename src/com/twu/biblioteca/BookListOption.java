package com.twu.biblioteca;

import static com.twu.biblioteca.Messages.ENTER_BOOK_NAME;
import static com.twu.biblioteca.Messages.PROMPT_USER_FOR_CHECKOUT_BOOK;

public class BookListOption {
    OutputHandler outputHandler;
    CheckOutItem checkOutItem;

    BookListOption(OutputHandler outputHandler, CheckOutItem checkOutItem) {
        this.checkOutItem = checkOutItem;
        this.outputHandler = outputHandler;
    }
    public void performAction(Books books) {
        outputHandler.display(books);
        //for biblioteca to work remove coments
//        outputHandler.display(PROMPT_USER_FOR_CHECKOUT_BOOK);
//        if (checkOutItem.isInterestedToCheckOut()) {
//            outputHandler.display(ENTER_BOOK_NAME);
//            checkOutItem.checkOutBook();
//        }
    }
}
