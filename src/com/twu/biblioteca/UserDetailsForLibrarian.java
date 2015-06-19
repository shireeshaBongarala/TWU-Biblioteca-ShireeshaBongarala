package com.twu.biblioteca;

import java.util.Map;
import java.util.Set;

public class UserDetailsForLibrarian {
    OutputHandler outputHandler;

    UserDetailsForLibrarian(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;

    }

    public void displayBookList() {
        Set<Map.Entry<Book, User>> entrySet = EntryPoint.bookUserHashMap.entrySet();

        for (Map.Entry<Book, User> entry : entrySet) {
            Book book = entry.getKey();
            User user = entry.getValue();
            String output = book.toString() + user.toString();
            outputHandler.display(output);
        }
    }
}
