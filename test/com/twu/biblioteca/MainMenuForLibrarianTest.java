package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

public class MainMenuForLibrarianTest {
    @Mock
    OutputHandler outputHandlerMock;
    @Before
    public void setUp() {
        outputHandlerMock = mock(OutputHandler.class);

    }
    @Test
    public void shouldDisplayAllOptionsForUser() {
        MainMenuForLibrarian mainMenuForLibrarian = new MainMenuForLibrarian(outputHandlerMock);

        mainMenuForLibrarian.start();

        verify(outputHandlerMock, atLeast(1)).display(Messages.MAIN_MENU_FOR_LIBRARIAN);
    }
}
