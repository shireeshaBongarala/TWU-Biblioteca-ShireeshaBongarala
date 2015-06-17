package com.twu.biblioteca;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;

import static com.twu.biblioteca.Messages.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CheckOutItemTest {
    @Mock
    private OutputHandler outputHandlerMock;

    @Mock
    private InputHandler inputHandlerMock;

    @Mock
    private Library libraryMock;

    @Mock
    private Books books;

    @Test
    public void shouldDisplayUnSuccessfulCheckOutMessageWhenBookIsNotFound() {
        CheckOutItem checkOutItem = new CheckOutItem(outputHandlerMock, inputHandlerMock,libraryMock);
        checkOutItem.checkOutBook();

        when(inputHandlerMock.readLine())
                .thenReturn("C++");

        verify(outputHandlerMock).display(THAT_BOOK_IS_NOT_AVAILABLE);
    }

    @Test
    public void shouldReturnTrueIfUserIsInterestedToCheckOutABook() {
        InputHandler inputHandler = new InputHandler(new ByteArrayInputStream("\ny".getBytes()));
        CheckOutItem checkOutItem = new CheckOutItem(outputHandlerMock, inputHandler,libraryMock);

        boolean actualResult = checkOutItem.isInterestedToCheckOut();

        assertThat(actualResult,is(true));
    }

    @Test
    public void shouldReturnFalseIfUserIsNotInterestedToCheckOutABook() {
        InputHandler inputHandler = new InputHandler(new ByteArrayInputStream("\nn".getBytes()));
        CheckOutItem checkOutItem = new CheckOutItem(outputHandlerMock, inputHandler,libraryMock);

        boolean actualResult = checkOutItem.isInterestedToCheckOut();

        assertThat(actualResult,is(false));

    }
    @Test
    public void shouldDisplaySuccessfulCheckOutMessageWhenRequiredBookIsAvailable(){
        Library library = new Library();
        InputHandler inputHandler = new InputHandler(new ByteArrayInputStream("C++".getBytes()));
        CheckOutItem checkOutItem = new CheckOutItem(outputHandlerMock,inputHandler,library);

        checkOutItem.checkOutBook();

        verify(outputHandlerMock).display(SUCCESSFUL_BOOK_CHECKOUT);
    }

    @Test
    public void shouldDisplaySuccessfulCheckOutMessageWhenRequiredMovieIsAvailable(){
        Library library = new Library();
        InputHandler inputHandler = new InputHandler(new ByteArrayInputStream("IronMan".getBytes()));
        CheckOutItem checkOutItem = new CheckOutItem(outputHandlerMock,inputHandler,library);

        checkOutItem.checkOutMovie();

        verify(outputHandlerMock).display(SUCCESSFUL_MOVIE_CHECKOUT);
    }
    @Test
    public void shouldDisplayUnSuccessfulCheckOutMessageWhenMovieIsNotFound() {
        CheckOutItem checkOutItem = new CheckOutItem(outputHandlerMock, inputHandlerMock,libraryMock);


        when(inputHandlerMock.readLine())
                .thenReturn("IronLady");
        checkOutItem.checkOutMovie();

        verify(outputHandlerMock).display(THAT_MOVIE_IS_NOT_AVAILABLE);
    }
}
