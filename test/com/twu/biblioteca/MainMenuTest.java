package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mock;

import static com.twu.biblioteca.Messages.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MainMenuTest {
   @Mock
   OutputHandler outputHandlerMock;
    @Test
    public void shouldDisplayMainMenuOptions() {
        outputHandlerMock = mock(OutputHandler.class);
        MainMenu mainMenu = new MainMenu(outputHandlerMock);

        mainMenu.displayOptions();

        verify(outputHandlerMock).display(MAIN_MENU_OPTIONS);
    }
}
