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
    @Mock
    User user;
    private Books books;
    private Movies movies;

    @Before
    public void setUp() {
        outputHandlerMock = mock(OutputHandler.class);
        inputHandlerMock = mock(InputHandler.class);
        checkOutItem = mock(CheckOutItem.class);
        returnItem = mock(ReturnItem.class);
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
                books, bookListOption, movieListOptionMock, movies, login,user,returnItem);

        when(inputHandlerMock.readInteger())
                .thenReturn(8);
        mainMenuForLoggedInUser.start();

        verify(outputHandlerMock, atLeast(1)).display(MAIN_MENU_FOR_LOGGEDIN_USER);
    }


    @Test
    public void shouldDisplayBookListWhenUserPressesOne() {
        MainMenuForLoggedInUser mainMenuForLoggedInUser = new MainMenuForLoggedInUser(outputHandlerMock, inputHandlerMock, checkOutItem,
                books, bookListOption, movieListOptionMock, movies, login,user,returnItem);

        when(inputHandlerMock.readInteger())
                .thenReturn(1,8);

        mainMenuForLoggedInUser.start();
        verify(bookListOption,atLeast(1)).performAction(books);
    }

    @Test
    public void shouldDisplayMovieListWhenUserPressesTwo() {
        MainMenuForLoggedInUser mainMenuForLoggedInUser = new MainMenuForLoggedInUser(outputHandlerMock, inputHandlerMock, checkOutItem,
                books, bookListOption, movieListOptionMock, movies, login,user,returnItem);

        when(inputHandlerMock.readInteger())
                .thenReturn(2,8);

        mainMenuForLoggedInUser.start();
        verify(movieListOptionMock).performAction(movies);
    }
    @Test
    public void shouldCallCheckoutBookWhenUserPressesOptionThree(){
        MainMenuForLoggedInUser mainMenuForLoggedInUser = new MainMenuForLoggedInUser(outputHandlerMock, inputHandlerMock, checkOutItem,
                books, bookListOption, movieListOptionMock, movies, login,user,returnItem);

        when(inputHandlerMock.readInteger())
                .thenReturn(3,8);

        mainMenuForLoggedInUser.start();
        verify(checkOutItem).checkOutBook();

    }
    @Test
    public void shouldCallReturnBookWhenUserPressesOptionFour(){
        MainMenuForLoggedInUser mainMenuForLoggedInUser = new MainMenuForLoggedInUser(outputHandlerMock, inputHandlerMock, checkOutItem,
                books, bookListOption, movieListOptionMock, movies, login,user,returnItem);

        when(inputHandlerMock.readInteger())
                .thenReturn(4,8);

        mainMenuForLoggedInUser.start();
        verify(returnItem).returnBook();
    }
    @Test
    public void shouldDisplayQuitMessageWhenUserPressesOptionSeven(){
        MainMenuForLoggedInUser mainMenuForLoggedInUser = new MainMenuForLoggedInUser(outputHandlerMock, inputHandlerMock, checkOutItem,
                books, bookListOption, movieListOptionMock, movies, login,user,returnItem);

        when(inputHandlerMock.readInteger())
                .thenReturn(8);

        mainMenuForLoggedInUser.start();

        verify(outputHandlerMock).display(QUIT_MESSAGE);

    }
    @Test
    public void shouldCallCheckoutMovieWhenUserPressesOptionFive(){
        MainMenuForLoggedInUser mainMenuForLoggedInUser = new MainMenuForLoggedInUser(outputHandlerMock, inputHandlerMock, checkOutItem,
                books, bookListOption, movieListOptionMock, movies, login,user,returnItem);

        when(inputHandlerMock.readInteger())
                .thenReturn(5,8);

        mainMenuForLoggedInUser.start();
        verify(checkOutItem).checkOutMovie();

    }
    @Test
    public void shouldCallReturnMovieWhenUserPressesOptionSix(){
        MainMenuForLoggedInUser mainMenuForLoggedInUser = new MainMenuForLoggedInUser(outputHandlerMock, inputHandlerMock, checkOutItem,
                books, bookListOption, movieListOptionMock, movies, login,user,returnItem);

        when(inputHandlerMock.readInteger())
                .thenReturn(6,8);

        mainMenuForLoggedInUser.start();
        verify(returnItem).returnMovie();
    }
    @Test
    public void shouldDisplayUserDetailsWhenUserPressesOptionSeven(){
        MainMenuForLoggedInUser mainMenuForLoggedInUser = new MainMenuForLoggedInUser(outputHandlerMock, inputHandlerMock, checkOutItem,
                books, bookListOption, movieListOptionMock, movies, login,user,returnItem);

        when(inputHandlerMock.readInteger())
                .thenReturn(7,8);

        mainMenuForLoggedInUser.start();
       verify(outputHandlerMock).display(EntryPoint.user);
    }
}
