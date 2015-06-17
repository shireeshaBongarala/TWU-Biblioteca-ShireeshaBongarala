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

    @Test
    public void shouldAddABookIfItIsValidBookToBeReturned() {
        Library library = new Library();
        ReturnItem returnItem = new ReturnItem(new ByteArrayInputStream("Let Us C".getBytes()),library);

        returnItem.getBookDetails(outputHandlerMock);

        verify(outputHandlerMock).display(SUCCESSFUL_BOOK_RETURN);
    }

    @Test
    public void shouldNotAddABookIfItIsValidBookToBeReturned() {
        Library library = new Library();
        ReturnItem returnItem = new ReturnItem(new ByteArrayInputStream("C++".getBytes()),library);

        returnItem.getBookDetails(outputHandlerMock);

        verify(outputHandlerMock).display(UNSUCCESSFUL_BOOK_RETURN);
    }
}
