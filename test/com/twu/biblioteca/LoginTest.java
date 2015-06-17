package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;

import static com.twu.biblioteca.Messages.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LoginTest {
    @Mock
    OutputHandler outputHandlerMock;
    @Mock
    InputHandler inputHandlerMock;

    @Test
    public void shouldPromptUserToInputLibraryId() {
        outputHandlerMock = mock(OutputHandler.class);
        Login login = new Login(outputHandlerMock,inputHandlerMock);

        login.getDetails();

        verify(outputHandlerMock).display(ENTER_LIBRARY_ID);
    }
    @Test
    public void shouldGetTheLibraryIDFromTheUser() {
        outputHandlerMock = mock(OutputHandler.class);
        inputHandlerMock = mock(InputHandler.class);
        Login login = new Login(outputHandlerMock,inputHandlerMock);

        login.getDetails();

      verify(inputHandlerMock).readLine();
    }
}
