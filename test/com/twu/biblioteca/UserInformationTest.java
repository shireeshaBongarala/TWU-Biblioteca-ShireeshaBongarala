package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserInformationTest {
    @Test
    public void shouldDisplayUserInformationFromLibraryId(){
        UserInformation userInformation = new UserInformation();

       User user = userInformation.getDetails("123-4567");

        assertThat(user.toString(),is("Name : shireesha Email : shiree@gmail.com Phone : 1233456 LibraryID :123-4567"));
    }
}
