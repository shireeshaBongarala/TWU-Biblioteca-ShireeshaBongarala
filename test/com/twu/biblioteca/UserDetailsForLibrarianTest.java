package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.HashMap;

import static com.twu.biblioteca.EntryPoint.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UserDetailsForLibrarianTest {
   @Mock
   OutputHandler outputHandlerMock;
    @Before
    public void setUp() {
        outputHandlerMock = mock(OutputHandler.class);
    }
    @Test
    public void shouldDisplayUserListWhoCheckedOutABook(){
        bookUserHashMap = new HashMap<Book, User>();
        bookUserHashMap.put(new Book("C++","Balagurusamy",1990),new User("shiree","shiree@abc.com",123456,"123-4567",1));
        UserDetailsForLibrarian userDetailsForLibrarian = new UserDetailsForLibrarian(outputHandlerMock);

        userDetailsForLibrarian.displayBookList();

        verify(outputHandlerMock).display(anyString());
    }
}
