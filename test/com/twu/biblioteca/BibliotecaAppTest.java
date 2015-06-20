package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;

import static com.twu.biblioteca.BibliotecaApp.*;
import static com.twu.biblioteca.EntryPoint.*;
import static com.twu.biblioteca.Messages.*;
import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class BibliotecaAppTest {
    @Mock
    private OutputHandler outputHandlerMock;
    @Mock
    private InputHandler inputHandlerMock;
    @Mock
    private ReturnItem returnItemMock;
    @Mock
    private CheckOutItem checkOutItemMock;
    @Mock
    private Books booksMock;
    @Mock
    private Movies moviesMock;
    @Mock
    private Authentication authenticationMock;
    @Mock
    private BookListOption bookListOptionMock;
    @Mock
    private MovieListOption movieListOptionMock;
    @Mock
    private UserDetailsForLibrarian userDetailsForLibrarianMock;
    @Mock
    private Login loginMock;
    @Mock
    private MainMenuForLibrary mainMenuForLibraryMock;
    @Mock
    private MainMenuForLoggedInUser mainMenuForLoggedInUserMock;
    @Mock
    private MainMenuForLibrarian mainMenuForLibrarianMock;
    @Mock
    private User userMock;

    @Before
    public void setUp(){
        initMocks(this);
    }

    @Test
    public void shouldDisplayWelcomeMessageWhenBibliotecaAppStarts() {
        Library library = new Library();
        Books expectedBooks = new Books(library.getAvailableBookList());
        user = new User("shiree","shiree@gmail.com",12345,"123-6789",0);
        loopVariable = 1;

        BibliotecaApp bibliotecaApp =
                new BibliotecaApp(outputHandlerMock, inputHandlerMock, expectedBooks, returnItemMock,
                        checkOutItemMock, moviesMock,authenticationMock,bookListOptionMock,
                        movieListOptionMock,userDetailsForLibrarianMock,loginMock,mainMenuForLibraryMock,mainMenuForLoggedInUserMock,mainMenuForLibrarianMock);
        bibliotecaApp.start();

        verify(outputHandlerMock).display(WELCOME_MESSAGE);
    }
    @Test
    public void shouldCallMainMenuForLibraryWhenUserIsVisitor(){
        Library library = new Library();
        Books expectedBooks = new Books(library.getAvailableBookList());
        user = new User("visitor", "visitor@gmail.com", 123456, "000-0000", 0);
        BibliotecaApp.loopVariable = 0;

        BibliotecaApp bibliotecaApp =
                new BibliotecaApp(outputHandlerMock, inputHandlerMock, expectedBooks, returnItemMock,
                        checkOutItemMock, moviesMock,authenticationMock,bookListOptionMock,
                        movieListOptionMock,userDetailsForLibrarianMock,loginMock,mainMenuForLibraryMock,mainMenuForLoggedInUserMock,mainMenuForLibrarianMock);


        when(mainMenuForLibraryMock.start())
                .thenReturn(1);
        bibliotecaApp.start();

        verify(mainMenuForLibraryMock,atLeast(1)).start();
    }
    @Test
    public void shouldCallMainMenuForLoggedInUserWhenUserIsLoggedInUser(){
        Library library = new Library();
        Books expectedBooks = new Books(library.getAvailableBookList());
        user = new User("visitor", "visitor@gmail.com", 123456, "000-0000", 1);
        BibliotecaApp.loopVariable = 0;

        BibliotecaApp bibliotecaApp =
                new BibliotecaApp(outputHandlerMock, inputHandlerMock, expectedBooks, returnItemMock,
                        checkOutItemMock, moviesMock,authenticationMock,bookListOptionMock,
                        movieListOptionMock,userDetailsForLibrarianMock,loginMock,mainMenuForLibraryMock,mainMenuForLoggedInUserMock,mainMenuForLibrarianMock);

        when(mainMenuForLoggedInUserMock.start())
                .thenReturn(1);
        bibliotecaApp.start();

        verify(mainMenuForLoggedInUserMock,atLeast(1)).start();
    }
    @Test
    public void shouldCallMainMenuForLibrarianWhenUserIsLibrarian(){
        Library library = new Library();
        Books expectedBooks = new Books(library.getAvailableBookList());
        user = new User("visitor", "visitor@gmail.com", 123456, "000-0000", 2);
        BibliotecaApp.loopVariable = 0;

        BibliotecaApp bibliotecaApp =
                new BibliotecaApp(outputHandlerMock, inputHandlerMock, expectedBooks, returnItemMock,
                        checkOutItemMock, moviesMock,authenticationMock,bookListOptionMock,
                        movieListOptionMock,userDetailsForLibrarianMock,loginMock,mainMenuForLibraryMock,mainMenuForLoggedInUserMock,mainMenuForLibrarianMock);

        when(mainMenuForLibrarianMock.start())
                .thenReturn(1);
        bibliotecaApp.start();

        verify(mainMenuForLibrarianMock,atLeast(1)).start();
    }
}
