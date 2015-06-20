package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class UserTest {
    @Test
    public void shouldDisplayUserInformationInRequiredFormat(){
        User user = new User("name","email",1234676,"123-4567",1);

        String actualUserDetails = "Name : name Email : email Phone : 1234676 LibraryID :123-4567\n";

        assertThat(actualUserDetails,is(user.toString()));
    }

    @Test
    public void shouldReturnTrueIfTwoUsersAreSame(){
        User user = new User("shireesha","abc@gmail.com",12345,"123-4567",0);

        User anotherUser = new User("shireesha","bdc@gmail.com",789833,"123-4567",8);

        assertTrue(user.equals(anotherUser));
    }
    @Test
    public void shouldReturnUserType(){
        User user = new User("shireesha","abc@gmail.com",12345,"123-4567",0);

        int actualUserType = user.getUserType();

        assertThat(actualUserType,is(0));
    }
}
