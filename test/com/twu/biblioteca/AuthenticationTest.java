package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertThat;

public class AuthenticationTest {
    @Test
    public void shouldReturnTrueIfUserCredentialsAreValid() {
        Authentication authentication = new Authentication();

        boolean actualResult = authentication.validate("123-4567","password123");

        assertThat(actualResult,is(true));
    }
}
