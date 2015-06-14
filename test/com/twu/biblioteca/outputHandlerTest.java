package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class outputHandlerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    outputHandler outputHandler;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        outputHandler = new outputHandler(new PrintStream(outContent));
    }

    @Test
    public void testToCheckIfCorrectWelcomeMessageIsPrintedOnConsole() {
        outputHandler.display(Messages.WELCOME_MESSAGE);

        String actualMessage = Messages.WELCOME_MESSAGE;

        assertThat(actualMessage, is(outContent.toString()));
    }

    @Test
    public void testToCheckIfListOfBooksAreDisplayedOnConsole() {
        outputHandler.display(new Books(EntryPoint.initializeListOfBooks()));

        String actualListOfBooks = "C Balagurusamy    Balagurusamy    1990\n" +
                "C++    Balagurusamy    1995\n" +
                "Java    O'Reilly    2012\n";

        assertThat(actualListOfBooks, is(outContent.toString()));
    }

    @Test
    public void testToCheckIfMainMenuOptionsAreDisplayedOnScreen(){
        outputHandler.display(Messages.MENU_OPTIONS);

        String actualMainMenuOptions = Messages.MENU_OPTIONS;

        assertThat(actualMainMenuOptions,is(outContent.toString()));
    }

    @Test
    public void testToCheckIfCorrectInvalidChoiceMessageIsDisplayedOnScreen(){
        outputHandler.display(Messages.ERROR_MESSAGE);

        String actualErrorMessage = Messages.ERROR_MESSAGE;

        assertThat(actualErrorMessage,is(outContent.toString()));
    }
    @Test
    public void testToCheckIfQuitMessageIsDisplayedOnScreen(){
        outputHandler.display(Messages.QUIT_MESSAGE);

        String actualErrorMessage = Messages.QUIT_MESSAGE;

        assertThat(actualErrorMessage,is(outContent.toString()));
    }


    @After
    public void tearDown() {
        System.setOut(null);
    }

}