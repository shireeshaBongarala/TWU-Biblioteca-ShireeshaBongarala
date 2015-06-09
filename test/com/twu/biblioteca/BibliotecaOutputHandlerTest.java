package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class BibliotecaOutputHandlerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testToCheckIfCorrectWelcomeMessageIsPrintedOnConsole() {
        BibliotecaOutputHandler bibliotecaOutputHandler = new BibliotecaOutputHandler();
        bibliotecaOutputHandler.displayWelcomeMessage();

        String actualMessage = "Welcome to Biblioteca Library Management System";

        assertThat(actualMessage, is(outContent.toString()));
    }
    @Test
    public void testToCheckIfListOfBooksAreDisplayedOnConsole() {
        BibliotecaOutputHandler bibliotecaOutputHandler = new BibliotecaOutputHandler();
        bibliotecaOutputHandler.displayListOfBooks(new Books(List.getListOfBooks()));

        String actualListOfBooks = "C Balagurusamy    Balagurusamy    1990\n" +
                "C++    Balagurusamy    1995\n" +
                "Java    O'Reilly    2012\n";

        assertThat(actualListOfBooks.toString(), is(outContent.toString()));
    }

    @Test
    public void testToCheckIfMainMenuOptionsAreDisplayedOnScreen(){
        BibliotecaOutputHandler bibliotecaOutputHandler = new BibliotecaOutputHandler();
        bibliotecaOutputHandler.displayMainMenuOptions();

        String actualMainMenuOptions = "Select choice:\n1. Book List\n";

        assertThat(actualMainMenuOptions.toString(),is(outContent.toString()));

    }

    @Test
    public void testToCheckIfCorrectInvalidChoiceMessageIsDisplayedOnScreen(){
        BibliotecaOutputHandler bibliotecaOutputHandler = new BibliotecaOutputHandler();
        bibliotecaOutputHandler.displayErrorMessage();

        String actualErrorMessage = "Select a valid option!";

        assertThat(actualErrorMessage,is(outContent.toString()));
    }


    @After
    public void tearDown() {
        System.setOut(new PrintStream(outContent));
    }

}
