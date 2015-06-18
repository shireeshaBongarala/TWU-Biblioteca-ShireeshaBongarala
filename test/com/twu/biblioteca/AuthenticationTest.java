package com.twu.biblioteca;

import org.hamcrest.MatcherAssert;
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
    @Test
    public void shouldReturnTwoIfUserIsALibrarianOfLibrary(){
        Authentication authentication = new Authentication();

        authentication.validate("000-0123","password123");
        int actualResult = authentication.getUserState();

        assertThat(actualResult, is(2));
    }
    @Test
    public void shouldReturnZeroIfUserIsAVisitorOfLibrary(){
        Authentication authentication = new Authentication();

        authentication.validate("123-0567","password123");
        int actualResult = authentication.getUserState();

        assertThat(actualResult, is(0));
    }
    @Test
    public void shouldDisplayUserInformationFromLibraryId(){
        Authentication authentication = new Authentication();

        User user = authentication.getDetails("123-4567");

        MatcherAssert.assertThat(user.toString(), is("Name : shireesha Email : shiree@gmail.com Phone : 1233456 LibraryID :123-4567"));
    }
}
