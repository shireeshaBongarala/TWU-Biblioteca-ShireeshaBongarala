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
    ReturnItem returnItem;
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
                books, bookListOption, movieListOptionMock, movies, login,returnItem);

        when(inputHandlerMock.readInteger())
                .thenReturn(1, 4);
        mainMenuForLoggedInUser.start();

        verify(outputHandlerMock, atLeast(1)).display(MAIN_MENU_FOR_LOGGEDIN_USER);
    }


    @Test
    public void shouldDisplayBookListWhenUserPressesOne() {
        MainMenuForLoggedInUser mainMenuForLoggedInUser = new MainMenuForLoggedInUser(outputHandlerMock, inputHandlerMock, checkOutItem,
                books, bookListOption, movieListOptionMock, movies, login,returnItem);

        when(inputHandlerMock.readInteger())
                .thenReturn(1,4);

        mainMenuForLoggedInUser.start();
        verify(bookListOption,atLeast(1)).performAction(books);
    }

    @Test
    public void shouldDisplayMovieListWhenUserPressesTwo() {
        MainMenuForLoggedInUser mainMenuForLoggedInUser = new MainMenuForLoggedInUser(outputHandlerMock, inputHandlerMock, checkOutItem,
                books, bookListOption, movieListOptionMock, movies, login,returnItem);

        when(inputHandlerMock.readInteger())
                .thenReturn(2,4);

        mainMenuForLoggedInUser.start();
        verify(movieListOptionMock).performAction(movies);
    }
    @Test
    public void shouldCallCheckoutBookWhenUserPressesOptionThree(){
        MainMenuForLoggedInUser mainMenuForLoggedInUser = new MainMenuForLoggedInUser(outputHandlerMock, inputHandlerMock, checkOutItem,
                books, bookListOption, movieListOptionMock, movies, login,returnItem);

        when(inputHandlerMock.readInteger())
                .thenReturn(3,4);

        mainMenuForLoggedInUser.start();
        verify(checkOutItem).checkOutBook();

    }
}
