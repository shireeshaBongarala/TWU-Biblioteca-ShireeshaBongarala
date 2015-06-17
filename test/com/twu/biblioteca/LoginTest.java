package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.List;

import static com.twu.biblioteca.Messages.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class LoginTest {
    @Mock
    OutputHandler outputHandlerMock;
    @Mock
    InputHandler inputHandlerMock;

    @Test
    public void shouldPromptUserToInputLibraryId() {
        outputHandlerMock = mock(OutputHandler.class);
        inputHandlerMock = mock(InputHandler.class);
        Login login = new Login(outputHandlerMock, inputHandlerMock);
        ArgumentCaptor<String> textCaptor = ArgumentCaptor.forClass(String.class);

        when(inputHandlerMock.readLine())
                .thenReturn("C");
        login.getDetails();

        verify(outputHandlerMock,times(2)).display(textCaptor.capture());
        List<String> capturedText = textCaptor.getAllValues();
        assertEquals(ENTER_LIBRARY_ID, capturedText.get(0));
    }

    @Test
    public void shouldGetTheLibraryIDFromTheUser() {
        outputHandlerMock = mock(OutputHandler.class);
        inputHandlerMock = mock(InputHandler.class);
        Login login = new Login(outputHandlerMock, inputHandlerMock);

        login.getDetails();

        verify(inputHandlerMock,times(2)).readLine();
    }

    @Test
    public void shouldPromptUserToInputPassword() {
        outputHandlerMock = mock(OutputHandler.class);
        inputHandlerMock = mock(InputHandler.class);
        Login login = new Login(outputHandlerMock, inputHandlerMock);
        ArgumentCaptor<String> textCaptor = ArgumentCaptor.forClass(String.class);

        login.getDetails();

        verify(outputHandlerMock,times(2)).display(textCaptor.capture());
        List<String> capturedText = textCaptor.getAllValues();
        assertEquals(ENTER_PASSWORD, capturedText.get(1));
    }
    @Test
    public void shouldGetThePasswordFromTheUser() {
        outputHandlerMock = mock(OutputHandler.class);
        inputHandlerMock = mock(InputHandler.class);
        Login login = new Login(outputHandlerMock, inputHandlerMock);

        login.getDetails();

        verify(inputHandlerMock,times(2)).readLine();
    }
}
