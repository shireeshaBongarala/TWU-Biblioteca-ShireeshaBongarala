package com.twu.biblioteca;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.List;

import static com.twu.biblioteca.Messages.*;
import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.when;

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

    @Test
    public void shouldDisplayWelcomeMessageWhenBibliotecaAppStarts() {
        Library library = new Library();
        Books expectedBooks = new Books(library.getAvailableBookList());

        when(inputHandlerMock.readInteger())
                .thenReturn(5);

        BibliotecaApp bibliotecaApp =
                new BibliotecaApp(outputHandlerMock, inputHandlerMock, expectedBooks, returnItemMock, checkOutItemMock, moviesMock);
        bibliotecaApp.start();


        verify(outputHandlerMock,atLeast(1)).display(WELCOME_MESSAGE);
    }

    @Test
    public void shouldDisplayListOfBooksWhenChoiceIsOne(){
        Library library = new Library();
        Books expectedBooks = new Books(library.getAvailableBookList());
        when(inputHandlerMock.readInteger()).thenReturn(1,1,1, 5);

        BibliotecaApp bibliotecaApp =
                new BibliotecaApp(outputHandlerMock, inputHandlerMock, expectedBooks, returnItemMock, checkOutItemMock, moviesMock);

        bibliotecaApp.start();

        verify(outputHandlerMock, atLeast(1)).display(expectedBooks);
    }

    @Test
    public void shouldDisplayQuitMessageWhenChoiceIsFive(){
        Library library = new Library();
        Books expectedBooks = new Books(library.getAvailableBookList());

        when(inputHandlerMock.readInteger())
                .thenReturn(5);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(
                outputHandlerMock, inputHandlerMock, expectedBooks , returnItemMock, checkOutItemMock,moviesMock);
        bibliotecaApp.start();

        verify(outputHandlerMock, atLeast(1)).display(QUIT_MESSAGE);
    }

    @Test
    public void shouldDisplayErrorMessageWhenChoiceIsNeitherOneOrTwo(){
        Library library = new Library();
        Books expectedBooks = new Books(library.getAvailableBookList());
        BibliotecaApp bibliotecaApp = new BibliotecaApp(
                outputHandlerMock, inputHandlerMock, expectedBooks, returnItemMock, checkOutItemMock,moviesMock);
        when(inputHandlerMock.readInteger())
                .thenReturn(8,5);
        bibliotecaApp.start();

        verify(outputHandlerMock, atLeast(1)).display(ERROR_MESSAGE);
    }

    @Test
    public void shouldGetBookDetailsIfUserWantsToReturnABook() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(
                outputHandlerMock, inputHandlerMock, booksMock, returnItemMock, checkOutItemMock,moviesMock);

        when(inputHandlerMock.readInteger())
                .thenReturn(2,5);
               bibliotecaApp.start();

        verify(returnItemMock).returnBook();
    }

    @Test
    public void shouldCallCheckoutBookIfUserIsInterestedToCheckOutABook() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(
                outputHandlerMock, inputHandlerMock, booksMock, returnItemMock, checkOutItemMock,moviesMock);

        when(inputHandlerMock.readInteger())
                .thenReturn(1,5);
        when(checkOutItemMock.isInterestedToCheckOut())
                .thenReturn(true);
        bibliotecaApp.start();

        verify(checkOutItemMock).checkOutBook();
    }
    @Test
    public void shouldDisplayListOfMoviesWhenUserSelectsChoiceThree(){
        Library library = new Library();
        Movies movies = new Movies((library.getAvailableMovieList()));

        BibliotecaApp bibliotecaApp = new BibliotecaApp(
                outputHandlerMock, inputHandlerMock, booksMock, returnItemMock, checkOutItemMock,movies);

        when(inputHandlerMock.readInteger())
                .thenReturn(3,5);
        bibliotecaApp.start();

        verify(outputHandlerMock).display(movies);
    }
    @Test
    public void shouldPromptUserForCheckingOutMoviesWhenUserSelectsChoiceThree(){
        Library library = new Library();
        Movies movies = new Movies((library.getAvailableMovieList()));
        ArgumentCaptor <String> textCaptor = ArgumentCaptor.forClass(String.class);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(
                outputHandlerMock, inputHandlerMock, booksMock, returnItemMock, checkOutItemMock,movies);

        when(inputHandlerMock.readInteger())
                .thenReturn(3,5);
        bibliotecaApp.start();

        verify(outputHandlerMock,times(5)).display(textCaptor.capture());
        List<String> capturedText = textCaptor.getAllValues();
        assertEquals(PROMPT_USER_FOR_CHECKOUT_MOVIE, capturedText.get(2));
    }
    @Test
    public void shouldCallCheckoutMovieIfUserIsInterestedToCheckOutAMovie() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(
                outputHandlerMock, inputHandlerMock, booksMock, returnItemMock, checkOutItemMock,moviesMock);

        when(inputHandlerMock.readInteger())
                .thenReturn(3,5);
        when(checkOutItemMock.isInterestedToCheckOut())
                .thenReturn(true);
        bibliotecaApp.start();

        verify(checkOutItemMock).checkOutMovie();
    }
    @Test
    public void shouldCallReturnMovieIfUserSelectsChoiceFour() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(
                outputHandlerMock, inputHandlerMock, booksMock, returnItemMock, checkOutItemMock,moviesMock);

        when(inputHandlerMock.readInteger())
                .thenReturn(4,5);
        when(checkOutItemMock.isInterestedToCheckOut())
                .thenReturn(true);
        bibliotecaApp.start();

        verify(returnItemMock).returnMovie();
    }
}
