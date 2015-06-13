package com.twu.biblioteca;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
//
@RunWith(MockitoJUnitRunner.class)
public class BibliotecaAppTest {
    @Mock
    private BibliotecaOutputHandler bibliotecaOutputHandlerMock;

    @Mock
    private MainMenu mainMenuMock;

    @Test
    public void shouldDisplayListOfBooksWhenChoiceIsOne(){
        Books expectedBooks = new Books(BibliotecaApp.initializeListOfBooks());
        when(mainMenuMock.getChoice(bibliotecaOutputHandlerMock)).thenReturn(1,1,1, 2);

        BibliotecaApp bibliotecaApp =
                new BibliotecaApp(bibliotecaOutputHandlerMock, mainMenuMock, expectedBooks);

        bibliotecaApp.start();

        verify(bibliotecaOutputHandlerMock, atLeast(1)).display(expectedBooks);
    }

    @Test
    public void shouldDisplayQuitMessageWhenChoiceIsTwo(){
        Books expectedBooks = new Books(BibliotecaApp.initializeListOfBooks());

        when(mainMenuMock.getChoice(bibliotecaOutputHandlerMock))
                .thenReturn(2);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(
                bibliotecaOutputHandlerMock, mainMenuMock, expectedBooks);
        bibliotecaApp.start();

        verify(bibliotecaOutputHandlerMock, atLeast(1)).display(Messages.QUIT_MESSAGE);
    }

    @Test
    public void shouldDisplayErrorMessageWhenChoiceIsNeitherOneOrTwo(){
        Books expectedBooks = new Books(BibliotecaApp.initializeListOfBooks());
        when(mainMenuMock.getChoice(bibliotecaOutputHandlerMock))
                .thenReturn(3,2);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(
                bibliotecaOutputHandlerMock, mainMenuMock, expectedBooks);
        bibliotecaApp.start();

        verify(bibliotecaOutputHandlerMock, atLeast(1)).display(Messages.ERROR_MESSAGE);
    }
}
