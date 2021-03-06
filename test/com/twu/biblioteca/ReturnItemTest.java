package com.twu.biblioteca;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;

import static com.twu.biblioteca.Messages.*;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ReturnItemTest {
    @Mock
    private OutputHandler outputHandlerMock;
    @Mock
    private Library libraryMock;
    @Mock
    private InputHandler inputHandlerMock;


    @Test
    public void shouldNotAddABookIfItIsNotValidBookToBeReturned() {
        Library library = new Library();
        InputHandler inputHandler = new InputHandler(new ByteArrayInputStream("\nC++".getBytes()));
        ReturnItem returnItem = new ReturnItem(outputHandlerMock,inputHandler,library);

        returnItem.returnBook();

        verify(outputHandlerMock).display(UNSUCCESSFUL_BOOK_RETURN);
    }


    @Test
    public void shouldDisplaySuccessfulReturnMessageWhenItIsAValidBook(){
        Library library = new Library();
        InputHandler inputHandler = new InputHandler(new ByteArrayInputStream("\nLet Us C".getBytes()));
        ReturnItem returnItem = new ReturnItem(outputHandlerMock,inputHandler,library);

        returnItem.returnBook();

        verify(outputHandlerMock).display(SUCCESSFUL_BOOK_RETURN);
    }
    @Test
    public void shouldNotAddAMovieIfItIsNotValidMovieToBeReturned() {
        Library library = new Library();
        InputHandler inputHandler = new InputHandler(new ByteArrayInputStream("\nIronMan".getBytes()));
        ReturnItem returnItem = new ReturnItem(outputHandlerMock,inputHandler,library);

        returnItem.returnMovie();

        verify(outputHandlerMock).display(UNSUCCESSFUL_MOVIE_RETURN);

    }
    @Test
    public void shouldDisplaySuccessfulReturnMessageWhenItIsAValidMovie(){
        Library library = new Library();
        InputHandler inputHandler = new InputHandler(new ByteArrayInputStream("\nDarkKnight".getBytes()));
        ReturnItem returnItem = new ReturnItem(outputHandlerMock,inputHandler,library);

        returnItem.returnMovie();

        verify(outputHandlerMock).display(SUCCESSFUL_MOVIE_RETURN);
    }
}
