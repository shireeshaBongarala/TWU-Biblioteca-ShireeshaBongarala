package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

public class MainMenuForLibrarianTest {
    @Mock
    OutputHandler outputHandlerMock;
    @Mock
    InputHandler inputHandlerMock;
    @Mock
    Books books;
    @Mock
    BookListOption bookListOption;
    @Before
    public void setUp() {
        outputHandlerMock = mock(OutputHandler.class);
        inputHandlerMock = mock(InputHandler.class);
        bookListOption = mock(BookListOption.class);
        books = mock(Books.class);

    }
    @Test
    public void shouldDisplayAllOptionsForUser() {
        MainMenuForLibrarian mainMenuForLibrarian = new MainMenuForLibrarian(outputHandlerMock,inputHandlerMock,bookListOption,books);

        mainMenuForLibrarian.start();

        verify(outputHandlerMock, atLeast(1)).display(Messages.MAIN_MENU_FOR_LIBRARIAN);
    }
    @Test
    public void shouldDisplayBookListWhenUserPressesOne() {
        MainMenuForLibrarian mainMenuForLibrarian = new MainMenuForLibrarian(outputHandlerMock,inputHandlerMock,bookListOption,books);

     when(inputHandlerMock.readInteger())
             .thenReturn(1);
        mainMenuForLibrarian.start();

        verify(bookListOption,atLeast(1)).performAction(books);
    }
}
