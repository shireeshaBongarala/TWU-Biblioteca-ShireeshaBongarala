package com.twu.biblioteca;

import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class LibraryTest {
    @Test
    public void shouldBeInitializedWithStaticBookList() {
        Library library = new Library();
        ArrayList <Book> books;

        books = library.getAvailableBookList();

        assertFalse(books.isEmpty());
    }
    @Test
    public void shouldAddToAvialableBookListWhenItIsValidCheckedOutBook() {
        Library library = new Library();

        String bookName = "Let Us C";

        assertThat(library.additionToAvailableBookListIsSuccessful(bookName),is(true));
    }

    @Test
    public void shouldCheckOutBookFromAvailableBookListWhenBookIsValidAvaialbleBook() {
        Library library = new Library();
        EntryPoint.bookUserHashMap = new HashMap<Book, User>();

        String bookName = "C++";

        assertThat(library.additionToCheckedOutBookListIsSuccessful(bookName),is(true));
    }
    @Test
    public void shouldNotCheckOutBookFromAvailableBookListWhenBookIsValidAvailableBook() {
        Library library = new Library();

        String bookName = "C";

        assertThat(library.additionToCheckedOutBookListIsSuccessful(bookName),is(false));
    }
    @Test
    public void shouldBeInitializedWithStaticMovieList() {
        Library library = new Library();
        ArrayList <Movie> movies;

        movies = library.getAvailableMovieList();

        assertFalse(movies.isEmpty());
    }
    @Test
    public void shouldCheckOutMovieFromAvailableMovieListWhenMovieIsAValidAvaialableMovie() {
        Library library = new Library();
        EntryPoint.movieUserHashMap = new HashMap<Movie, User>();

        String movieName = "IronMan";

        assertThat(library.additionToCheckedOutMovieListIsSuccessful(movieName),is(true));
    }
    @Test
    public void shouldAddToAvialableMovieListWhenItIsValidCheckedOutMovie() {
        Library library = new Library();

        String movieName = "DarkKnight";

        assertThat(library.additionToAvailableMovieListIsSuccessful(movieName),is(true));
    }
    @Test
    public void shouldNotAddToAvailableMovieListWhenItIsNotAValidCheckedOutMovie(){
        Library library = new Library();

        String movieName = "IronMan";

        assertThat(library.additionToAvailableBookListIsSuccessful(movieName),is(false));
    }
    @Test
    public void shouldReturnFalseIIfTheBookIsNotAvailable(){
        Library library = new Library();

        String movieName = "gggg";

        assertThat(library.additionToCheckedOutMovieListIsSuccessful(movieName), is(false));
    }
}


