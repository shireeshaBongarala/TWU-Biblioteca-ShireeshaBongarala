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
    private Books books;

    @Before
    public void setUp() {
        outputHandlerMock = mock(OutputHandler.class);
        inputHandlerMock = mock(InputHandler.class);
        checkOutItem = mock(CheckOutItem.class);
        Library library = new Library();
        books = new Books(library.getAvailableBookList());

    }

    @Test
    public void shouldDisplayMainMenuOptions() {

        MainMenuForLibrary mainMenuForLibrary = new MainMenuForLibrary(outputHandlerMock, inputHandlerMock, checkOutItem, books);

        mainMenuForLibrary.start();

        verify(outputHandlerMock, atLeast(1)).display(MAIN_MENU_OPTIONS);
    }

    @Test
    public void shouldDisplayBookListWhenUserPressesOne() {
        MainMenuForLibrary mainMenuForLibrary = new MainMenuForLibrary(outputHandlerMock, inputHandlerMock, checkOutItem, books);

        when(inputHandlerMock.readInteger())
                .thenReturn(1);
        when(checkOutItem.isInterestedToCheckOut())
                .thenReturn(true);
        mainMenuForLibrary.start();

        verify(outputHandlerMock, atLeast(1)).display(books);
    }
}
