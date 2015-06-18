package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static com.twu.biblioteca.Messages.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

public class MainMenuForLoggedInUserTest {

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
    @Mock
    Authentication authentication;
    @Mock
    Login login;
    private Books books;
    private Movies movies;

    @Before
    public void setUp() {
        outputHandlerMock = mock(OutputHandler.class);
        inputHandlerMock = mock(InputHandler.class);
        checkOutItem = mock(CheckOutItem.class);
        bookListOption = mock(BookListOption.class);
        movieListOptionMock = mock(MovieListOption.class);
        login = mock(Login.class);
        Library library = new Library();
        books = new Books(library.getAvailableBookList());
        movies = new Movies(library.getAvailableMovieList());
    }

    @Test
    public void shouldDisplayAllOptionsForUser() {
        MainMenuForLoggedInUser mainMenuForLoggedInUser = new MainMenuForLoggedInUser(outputHandlerMock, inputHandlerMock, checkOutItem,
                books, bookListOption, movieListOptionMock, movies, login);

        when(inputHandlerMock.readInteger())
                .thenReturn(1, 4);
        mainMenuForLoggedInUser.start();

        verify(outputHandlerMock, atLeast(1)).display(MAIN_MENU_FOR_LOGGEDIN_USER);
    }
}
