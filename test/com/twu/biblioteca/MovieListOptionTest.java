package com.twu.biblioteca;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

public class MovieListOptionTest {
    @Mock
    OutputHandler outputHandlerMock;
    @Mock
    CheckOutItem checkOutItemMock;

    @Before
    public void setUp() {
        outputHandlerMock = mock(OutputHandler.class);
        checkOutItemMock = mock(CheckOutItem.class);
    }
    @Test
    public void shouldDisplayListOfBooks() {
        MovieListOption movieListOption = new MovieListOption(outputHandlerMock, checkOutItemMock);
        Movies movies = new Movies(new Library().getAvailableMovieList());

        movieListOption.performAction(movies);

        verify(outputHandlerMock).display(movies);

    }
}
