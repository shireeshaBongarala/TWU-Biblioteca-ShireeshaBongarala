package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mock;


import static com.twu.biblioteca.Messages.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;


public class MainMenuForLibraryTest {

    @Mock
    OutputHandler outputHandlerMock;
    @Test
    public void shouldDisplayMainMenuOptions() {
        outputHandlerMock = mock(OutputHandler.class);
        MainMenuForLibrary mainMenuForLibrary = new MainMenuForLibrary(outputHandlerMock);

        mainMenuForLibrary.start();

        verify(outputHandlerMock, atLeast(1)).display(MAIN_MENU_OPTIONS);
    }
}
