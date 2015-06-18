package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;


import java.util.List;

import static com.twu.biblioteca.Messages.*;
import static org.junit.Assert.assertEquals;
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
    private Books books;

    @Before
    public void setUp() {
        outputHandlerMock = mock(OutputHandler.class);
        inputHandlerMock = mock(InputHandler.class);
        checkOutItem = mock(CheckOutItem.class);
        bookListOption = mock(BookListOption.class);
        Library library = new Library();
        books = new Books(library.getAvailableBookList());

    }

    @Test
    public void shouldDisplayMainMenuOptions() {

        MainMenuForLibrary mainMenuForLibrary = new MainMenuForLibrary(outputHandlerMock, inputHandlerMock, checkOutItem, books,bookListOption);

        mainMenuForLibrary.start();

        verify(outputHandlerMock, atLeast(1)).display(MAIN_MENU_OPTIONS);
    }

    @Test
    public void shouldDisplayBookListWhenUserPressesOne() {
        MainMenuForLibrary mainMenuForLibrary = new MainMenuForLibrary(outputHandlerMock, inputHandlerMock, checkOutItem, books,bookListOption);

        when(inputHandlerMock.readInteger())
                .thenReturn(1);

        mainMenuForLibrary.start();
        verify(bookListOption).performAction(books);

    }
}
