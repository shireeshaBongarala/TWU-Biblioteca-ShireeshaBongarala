package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;


import java.util.List;

import static com.twu.biblioteca.Messages.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;


public class MainMenuForLibraryTest {

    @Mock
    OutputHandler outputHandlerMock;
    @Mock
    InputHandler inputHandlerMock;
    @Mock
    CheckOutItem checkOutItem;
    @Mock
    BookListOption bookListOption;
    @Mock
    MovieListOption movieListOptionMock;
    private Books books;
    private Movies movies;

    @Before
    public void setUp() {
        outputHandlerMock = mock(OutputHandler.class);
        inputHandlerMock = mock(InputHandler.class);
        checkOutItem = mock(CheckOutItem.class);
        bookListOption = mock(BookListOption.class);
        movieListOptionMock = mock(MovieListOption.class);
        Library library = new Library();
        books = new Books(library.getAvailableBookList());
        movies = new Movies(library.getAvailableMovieList());

    }

    @Test
    public void shouldDisplayMainMenuOptions() {

        MainMenuForLibrary mainMenuForLibrary = new MainMenuForLibrary(outputHandlerMock, inputHandlerMock, checkOutItem, books,bookListOption,movieListOptionMock,movies);

        mainMenuForLibrary.start();

        verify(outputHandlerMock, atLeast(1)).display(MAIN_MENU_OPTIONS);
    }

    @Test
    public void shouldDisplayBookListWhenUserPressesOne() {
        MainMenuForLibrary mainMenuForLibrary = new MainMenuForLibrary(outputHandlerMock, inputHandlerMock, checkOutItem, books,bookListOption,movieListOptionMock,movies);

        when(inputHandlerMock.readInteger())
                .thenReturn(1);

        mainMenuForLibrary.start();
        verify(bookListOption).performAction(books);

    }
    @Test
    public void shouldDisplayMovieListWhenUserPressesTwo() {
        MainMenuForLibrary mainMenuForLibrary = new MainMenuForLibrary(outputHandlerMock, inputHandlerMock, checkOutItem, books,bookListOption,movieListOptionMock,movies);

        when(inputHandlerMock.readInteger())
                .thenReturn(2);

        mainMenuForLibrary.start();
        verify(movieListOptionMock).performAction(movies);

    }
}