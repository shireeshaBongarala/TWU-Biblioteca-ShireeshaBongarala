package com.twu.biblioteca;

import java.util.Map;
import java.util.Set;

import static com.twu.biblioteca.EntryPoint.*;

public class UserDetailsForLibrarian {
    OutputHandler outputHandler;

    UserDetailsForLibrarian(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;

    }

    public void displayBookList() {
        Set<Map.Entry<Book, User>> entrySet = bookUserHashMap.entrySet();
        if (!entrySet.isEmpty()) {
            for (Map.Entry<Book, User> entry : entrySet) {
                Book book = entry.getKey();
                User user = entry.getValue();
                String output ="Book: " +  book.toString() + " " + user.toString();
                outputHandler.display(output);
            }
        }
    }

    public void displayMovieList() {
        Set<Map.Entry<Movie, User>> entrySet1 = movieUserHashMap.entrySet();
        if(!entrySet1.isEmpty()) {
            for (Map.Entry<Movie, User> entry : entrySet1) {
                Movie movie = entry.getKey();
                User user = entry.getValue();
                String output = "Movie: " + movie.toString() + "  " + user.toString();
                outputHandler.display(output);
            }

        }
    }
}
