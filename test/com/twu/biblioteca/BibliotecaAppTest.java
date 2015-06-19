package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

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
    private MainMenuForLibrary mainMenuForLibraryMock;
    @Mock
    private BookListOption bookListOptionMock;
    @Mock
    private MovieListOption movieListOptionMock;
    @Mock
    private UserDetailsForLibrarian userDetailsForLibrarianMock;
    @Mock
    private Login loginMock;

    @Before
    public void setUp(){
        initMocks(this);
    }

    @Test
    public void shouldDisplayWelcomeMessageWhenBibliotecaAppStarts() {
        Library library = new Library();
        Books expectedBooks = new Books(library.getAvailableBookList());

        when(inputHandlerMock.readInteger())
                .thenReturn(4);

        BibliotecaApp bibliotecaApp =
                new BibliotecaApp(outputHandlerMock, inputHandlerMock, expectedBooks, returnItemMock,
                        checkOutItemMock, moviesMock,authenticationMock,bookListOptionMock, movieListOptionMock,userDetailsForLibrarianMock,loginMock);
        bibliotecaApp.start();


        verify(outputHandlerMock,atLeast(1)).display(WELCOME_MESSAGE);
    }
}
