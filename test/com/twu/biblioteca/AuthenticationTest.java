package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AuthenticationTest {
    @Test
    public void shouldReturnTrueIfUserCredentialsAreValid() {
        Authentication authentication = new Authentication();

        boolean actualResult = authentication.validate("123-4567","password123");

        assertThat(actualResult,is(true));
    }
    @Test
    public void shouldReturnFalseIfUserCredentialsAreInValid(){
        Authentication authentication = new Authentication();

        boolean actualResult = authentication.validate("122-4567","password123");

        assertThat(actualResult, is(false));
    }

    @Test
    public void shouldReturnTrueIfTheUserCredentialsAreValidForLibrarian(){
        Authentication authentication = new Authentication();

        boolean actualResult = authentication.validate("000-0123","password123");

        assertThat(actualResult,is(true));
    }

    @Test
    public void shouldReturnOneIfUserIsAMemberOfLibrary(){
        Authentication authentication = new Authentication();

        authentication.validate("123-4567","password123");
        int actualResult = authentication.getUserState();

        assertThat(actualResult, is(1));
    }
}
