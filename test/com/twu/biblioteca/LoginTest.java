package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mock;

import static com.twu.biblioteca.Messages.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LoginTest {
    @Mock
    OutputHandler outputHandlerMock;
    @Test
    public void shouldPromptUserToInputLibraryId() {
        outputHandlerMock = mock(OutputHandler.class);
        Login login = new Login(outputHandlerMock);

        login.getDetails();

        verify(outputHandlerMock).display(ENTER_LIBRARY_ID);
    }
}
