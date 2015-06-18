package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

public class BookListOptionTest {
  @Mock
  OutputHandler outputHandlerMock;
    @Mock
    CheckOutItem checkOutItemMock;

    @Before
    public void setUp() {
        outputHandlerMock = mock(OutputHandler.class);
        checkOutItemMock = mock(CheckOutItem.class);
    }
    @Test
    public void shouldDisplayListOfBooks() {
        BookListOption bookListOption = new BookListOption(outputHandlerMock, checkOutItemMock);
        Books books = new Books(new Library().getAvailableBookList());

        bookListOption.performAction(books);

        verify(outputHandlerMock).display(books);

    }
}
