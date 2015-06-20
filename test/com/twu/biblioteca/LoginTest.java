package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.List;

import static com.twu.biblioteca.Messages.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class LoginTest {
    private Login login;
    @Mock
    OutputHandler outputHandlerMock;
    @Mock
    InputHandler inputHandlerMock;
    @Mock
    Authentication authentication;
    @Mock
    User user;

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
        login.performAction(user);

        verify(outputHandlerMock, times(2)).display(textCaptor.capture());
        List<String> capturedText = textCaptor.getAllValues();
        assertEquals(ENTER_LIBRARY_ID, capturedText.get(0));
    }


    @Test
    public void shouldGetTheLibraryIDFromTheUser() {
        login.performAction(user);

        verify(inputHandlerMock, times(3)).readLine();
    }

    @Test
    public void shouldPromptUserToInputPassword() {
        ArgumentCaptor<String> textCaptor = ArgumentCaptor.forClass(String.class);

        login.performAction(user);

        verify(outputHandlerMock, times(2)).display(textCaptor.capture());
        List<String> capturedText = textCaptor.getAllValues();
        assertEquals(ENTER_PASSWORD, capturedText.get(1));
    }

    @Test
    public void shouldGetThePasswordFromTheUser() {

        login.performAction(user);

        verify(inputHandlerMock, times(3)).readLine();
    }

    @Test
    public void shouldCallAuthenticateValidationWhenRequiredInputsAreAvailable() {
        when(inputHandlerMock.readLine())
                .thenReturn("\n","123-4567","password123");
        login.performAction(user);
        verify(authentication).validate("123-4567", "password123");
    }
    @Test
    public void shouldReturnUserState(){
        Login login = new Login(outputHandlerMock,inputHandlerMock,authentication);

        int actualUserState = login.getUserState();

        assertThat(actualUserState,is(0));
    }
}
