package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;



import static com.twu.biblioteca.Messages.*;
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
    @Mock
    Authentication authentication;
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
        bookListOption = mock(BookListOption.class);
        movieListOptionMock = mock(MovieListOption.class);
        login = mock(Login.class);
        user = mock(User.class);
        Library library = new Library();
        books = new Books(library.getAvailableBookList());
        movies = new Movies(library.getAvailableMovieList());

    }

    @Test
    public void shouldDisplayMainMenuOptions() {
        MainMenuForLibrary mainMenuForLibrary = new MainMenuForLibrary(outputHandlerMock, inputHandlerMock, checkOutItem,
                books, bookListOption, movieListOptionMock, movies, login,user);

        when(inputHandlerMock.readInteger())
                .thenReturn(1,4);
        mainMenuForLibrary.start();

        verify(outputHandlerMock, atLeast(1)).display(MAIN_MENU_OPTIONS);
    }

    @Test
    public void shouldDisplayBookListWhenUserPressesOne() {
        MainMenuForLibrary mainMenuForLibrary = new MainMenuForLibrary(outputHandlerMock, inputHandlerMock, checkOutItem,
                books, bookListOption, movieListOptionMock, movies, login,user);

        when(inputHandlerMock.readInteger())
                .thenReturn(1,4);

        mainMenuForLibrary.start();
        verify(bookListOption,atLeast(1)).performAction(books);
    }

    @Test
    public void shouldDisplayMovieListWhenUserPressesTwo() {
        MainMenuForLibrary mainMenuForLibrary = new MainMenuForLibrary(outputHandlerMock, inputHandlerMock, checkOutItem,
                books, bookListOption, movieListOptionMock, movies, login,user);

        when(inputHandlerMock.readInteger())
                .thenReturn(2,4);

        mainMenuForLibrary.start();
        verify(movieListOptionMock).performAction(movies);
    }

    @Test
    public void shouldCallLoginWhenUserPressesOptionThree() {
        MainMenuForLibrary mainMenuForLibrary = new MainMenuForLibrary(outputHandlerMock, inputHandlerMock, checkOutItem,
                books, bookListOption, movieListOptionMock, movies, login,user);

       when(user.getUserType())
               .thenReturn(1);
        when(inputHandlerMock.readInteger())
                .thenReturn(3,4);

        mainMenuForLibrary.start();

        verify(login).performAction(user);
    }
    @Test
    public void shouldDisplayQuitMessageWhenUserPressesOptionFour() {
        MainMenuForLibrary mainMenuForLibrary = new MainMenuForLibrary(outputHandlerMock, inputHandlerMock, checkOutItem,
                books, bookListOption, movieListOptionMock, movies, login,user);

        when(inputHandlerMock.readInteger())
                .thenReturn(4);

        mainMenuForLibrary.start();

        verify(outputHandlerMock).display(QUIT_MESSAGE);
    }
}
