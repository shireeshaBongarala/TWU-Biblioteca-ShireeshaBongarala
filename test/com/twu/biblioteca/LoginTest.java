package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.List;

import static com.twu.biblioteca.Messages.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class LoginTest {
    private Login login;
    @Mock
    OutputHandler outputHandlerMock;
    @Mock
    InputHandler inputHandlerMock;
    @Mock
    Authentication authentication;

    @Before
        public void setUp() {
        outputHandlerMock = mock(OutputHandler.class);
        inputHandlerMock = mock(InputHandler.class);
        authentication = mock(Authentication.class);
        login = new Login(outputHandlerMock, inputHandlerMock, authentication);
    }

    @Test
    public void shouldPromptUserToInputLibraryId() {
        ArgumentCaptor<String> textCaptor = ArgumentCaptor.forClass(String.class);

        when(inputHandlerMock.readLine())
                .thenReturn("C");
        login.getDetails();

        verify(outputHandlerMock, times(2)).display(textCaptor.capture());
        List<String> capturedText = textCaptor.getAllValues();
        assertEquals(ENTER_LIBRARY_ID, capturedText.get(0));
    }


    @Test
    public void shouldGetTheLibraryIDFromTheUser() {
        login.getDetails();

        verify(inputHandlerMock, times(2)).readLine();
    }

    @Test
    public void shouldPromptUserToInputPassword() {
        ArgumentCaptor<String> textCaptor = ArgumentCaptor.forClass(String.class);

        login.getDetails();

        verify(outputHandlerMock, times(2)).display(textCaptor.capture());
        List<String> capturedText = textCaptor.getAllValues();
        assertEquals(ENTER_PASSWORD, capturedText.get(1));
    }

    @Test
    public void shouldGetThePasswordFromTheUser() {

        login.getDetails();

        verify(inputHandlerMock, times(2)).readLine();
    }

    @Test
    public void shouldCallAuthenticateValidationWhenRequiredInputsAreAvailable() {
        when(inputHandlerMock.readLine())
                .thenReturn("123-4567","password123");
        login.getDetails();
        verify(authentication).validate("123-4567","password123");
    }
}
