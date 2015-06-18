package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserTest {
    @Test
    public void shouldDisplayUserInformationInRequiredFormat(){
        User user = new User("name","email",1234676,"123-4567",1);

        String actualUserDetails = "Name : name Email : email Phone : 1234676 LibraryID :123-4567";

        assertThat(actualUserDetails,is(user.toString()));
    }
}
