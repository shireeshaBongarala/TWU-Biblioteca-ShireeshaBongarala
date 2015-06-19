package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static com.twu.biblioteca.Messages.QUIT_MESSAGE;
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
    @Mock
    UserDetailsForLibrarian userDetailsForLibrarianMock;

    @Before
    public void setUp() {
        outputHandlerMock = mock(OutputHandler.class);
        inputHandlerMock = mock(InputHandler.class);
        bookListOptionMock = mock(BookListOption.class);
        movieListOptionMock = mock(MovieListOption.class);
        userDetailsForLibrarianMock = mock(UserDetailsForLibrarian.class);
        books = mock(Books.class);
        movies = mock(Movies.class);

    }

    @Test
    public void shouldDisplayAllOptionsForUser() {
        MainMenuForLibrarian mainMenuForLibrarian = new MainMenuForLibrarian(outputHandlerMock, inputHandlerMock,
                bookListOptionMock, books, movieListOptionMock, movies, userDetailsForLibrarianMock);

        mainMenuForLibrarian.start();

        verify(outputHandlerMock, atLeast(1)).display(Messages.MAIN_MENU_FOR_LIBRARIAN);
    }

    @Test
    public void shouldDisplayBookListWhenUserPressesOne() {
        MainMenuForLibrarian mainMenuForLibrarian = new MainMenuForLibrarian(outputHandlerMock, inputHandlerMock,
                bookListOptionMock, books, movieListOptionMock, movies, userDetailsForLibrarianMock);

        when(inputHandlerMock.readInteger())
                .thenReturn(1);
        mainMenuForLibrarian.start();

        verify(bookListOptionMock, atLeast(1)).performAction(books);
    }

    @Test
    public void shouldDisplayMovieListWhenUserPressesTwo() {
        MainMenuForLibrarian mainMenuForLibrarian = new MainMenuForLibrarian(outputHandlerMock, inputHandlerMock,
                bookListOptionMock, books, movieListOptionMock, movies, userDetailsForLibrarianMock);

        when(inputHandlerMock.readInteger())
                .thenReturn(2);
        mainMenuForLibrarian.start();

        verify(movieListOptionMock).performAction(movies);
    }

    @Test
    public void shouldDisplayDetailsOfUsersWhoCheckedoutBooksFromLibraryWhenUserPressesThree() {
        MainMenuForLibrarian mainMenuForLibrarian = new MainMenuForLibrarian(outputHandlerMock, inputHandlerMock,
                bookListOptionMock, books, movieListOptionMock, movies, userDetailsForLibrarianMock);

        when(inputHandlerMock.readInteger())
                .thenReturn(3);
        mainMenuForLibrarian.start();

        verify(userDetailsForLibrarianMock).displayBookList();
    }

    @Test
    public void shouldDisplayDetailsOfUsersWhoCheckedoutMoviesFromLibraryWhenLibrarianPressesThree() {
        MainMenuForLibrarian mainMenuForLibrarian = new MainMenuForLibrarian(outputHandlerMock, inputHandlerMock,
                bookListOptionMock, books, movieListOptionMock, movies, userDetailsForLibrarianMock);

        when(inputHandlerMock.readInteger())
                .thenReturn(3);
        mainMenuForLibrarian.start();

        verify(userDetailsForLibrarianMock).displayMovieList();
    }

    @Test
    public void shouldDisplayUserDetailsWhenUserPressesOptionFour() {
        MainMenuForLibrarian mainMenuForLibrarian = new MainMenuForLibrarian(outputHandlerMock, inputHandlerMock,
                bookListOptionMock, books, movieListOptionMock, movies, userDetailsForLibrarianMock);

        when(inputHandlerMock.readInteger())
                .thenReturn(4);
        mainMenuForLibrarian.start();

        verify(outputHandlerMock).display(EntryPoint.user);
    }

    @Test
    public void shouldDisplayQuitMessageWhenUserPressesOptionFive() {
        MainMenuForLibrarian mainMenuForLibrarian = new MainMenuForLibrarian(outputHandlerMock, inputHandlerMock,
                bookListOptionMock, books, movieListOptionMock, movies, userDetailsForLibrarianMock);

        when(inputHandlerMock.readInteger())
                .thenReturn(5);
        mainMenuForLibrarian.start();

        verify(outputHandlerMock).display(QUIT_MESSAGE);
    }
}
