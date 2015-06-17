package com.twu.biblioteca;

import static com.twu.biblioteca.Messages.*;

public class Login {
    OutputHandler outputHandler;

    Login(OutputHandler outputHandler){
        this.outputHandler =outputHandler;
    }
    public void getDetails() {
        outputHandler.display(ENTER_LIBRARY_ID);
    }
}
