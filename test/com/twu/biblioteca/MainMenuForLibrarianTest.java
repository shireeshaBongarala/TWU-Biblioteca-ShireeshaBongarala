package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

public class MainMenuForLibrarianTest {
    @Mock
    OutputHandler outputHandlerMock;
    @Mock
    InputHandler inputHandlerMock;
    @Mock
    Books books;
    @Mock
    Movies movies;
    @Mock
    BookListOption bookListOptionMock;
    @Mock
    MovieListOption movieListOptionMock;
    @Before
    public void setUp() {
        outputHandlerMock = mock(OutputHandler.class);
        inputHandlerMock = mock(InputHandler.class);
        bookListOptionMock = mock(BookListOption.class);
        movieListOptionMock = mock(MovieListOption.class);
        books = mock(Books.class);
        movies = mock(Movies.class);

    }
    @Test
    public void shouldDisplayAllOptionsForUser() {
        MainMenuForLibrarian mainMenuForLibrarian = new MainMenuForLibrarian(outputHandlerMock,inputHandlerMock, bookListOptionMock,books,movieListOptionMock,movies);

        mainMenuForLibrarian.start();

        verify(outputHandlerMock, atLeast(1)).display(Messages.MAIN_MENU_FOR_LIBRARIAN);
    }
    @Test
    public void shouldDisplayBookListWhenUserPressesOne() {
        MainMenuForLibrarian mainMenuForLibrarian = new MainMenuForLibrarian(outputHandlerMock,inputHandlerMock, bookListOptionMock,books,movieListOptionMock,movies);

     when(inputHandlerMock.readInteger())
             .thenReturn(1);
        mainMenuForLibrarian.start();

        verify(bookListOptionMock,atLeast(1)).performAction(books);
    }
    @Test
    public void shouldDisplayMovieListWhenUserPressesTwo() {
        MainMenuForLibrarian mainMenuForLibrarian = new MainMenuForLibrarian(outputHandlerMock,inputHandlerMock, bookListOptionMock,books,movieListOptionMock,movies);

        when(inputHandlerMock.readInteger())
                .thenReturn(2);
        mainMenuForLibrarian.start();

        verify(movieListOptionMock).performAction(movies);
    }
}
