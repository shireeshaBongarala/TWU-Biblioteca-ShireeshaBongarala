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
public class CheckOutTest {
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
        CheckOut checkOut = new CheckOut(outputHandlerMock, inputHandlerMock,libraryMock);
        checkOut.checkOutBook();

        when(inputHandlerMock.readLine())
                .thenReturn("C++");

        verify(outputHandlerMock).display(THAT_BOOK_IS_NOT_AVAILABLE);
    }

    @Test
    public void shouldReturnTrueIfUserIsInterestedToCheckOutABook() {
        InputHandler inputHandler = new InputHandler(new ByteArrayInputStream("\ny".getBytes()));
        CheckOut checkOut = new CheckOut(outputHandlerMock, inputHandler,libraryMock);

        boolean actualResult = checkOut.isInterestedToCheckOut();

        assertThat(actualResult,is(true));
    }

    @Test
    public void shouldReturnFalseIfUserIsNotInterestedToCheckOutABook() {
        InputHandler inputHandler = new InputHandler(new ByteArrayInputStream("\nn".getBytes()));
        CheckOut checkOut = new CheckOut(outputHandlerMock, inputHandler,libraryMock);

        boolean actualResult = checkOut.isInterestedToCheckOut();

        assertThat(actualResult,is(false));

    }
    @Test
    public void shouldDisplaySuccessfulCheckOutMessageWhenRequiredBookIsAvailable(){
        Library library = new Library();
        InputHandler inputHandler = new InputHandler(new ByteArrayInputStream("C++".getBytes()));
        CheckOut checkOut = new CheckOut(outputHandlerMock,inputHandler,library);

        checkOut.checkOutBook();

        verify(outputHandlerMock).display(SUCCESSFUL_BOOK_CHECKOUT);
    }

    @Test
    public void shouldDisplaySuccessfulCheckOutMessageWhenRequiredMovieIsAvailable(){
        Library library = new Library();
        InputHandler inputHandler = new InputHandler(new ByteArrayInputStream("IronMan".getBytes()));
        CheckOut checkOut = new CheckOut(outputHandlerMock,inputHandler,library);

        checkOut.checkOutMovie();

        verify(outputHandlerMock).display(SUCCESSFUL_MOVIE_CHECKOUT);
    }
    @Test
    public void shouldDisplayUnSuccessfulCheckOutMessageWhenMovieIsNotFound() {
        CheckOut checkOut = new CheckOut(outputHandlerMock, inputHandlerMock,libraryMock);


        when(inputHandlerMock.readLine())
                .thenReturn("IronLady");
        checkOut.checkOutMovie();

        verify(outputHandlerMock).display(THAT_MOVIE_IS_NOT_AVAILABLE);
    }
}

