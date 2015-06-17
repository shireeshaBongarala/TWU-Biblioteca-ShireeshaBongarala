package com.twu.biblioteca;

import static com.twu.biblioteca.Messages.*;

public class Login {
    OutputHandler outputHandler;
    InputHandler inputHandler;

    Login(OutputHandler outputHandler,InputHandler inputHandler){
        this.outputHandler = outputHandler;
        this.inputHandler = inputHandler;
    }
    public void getDetails() {
        outputHandler.display(ENTER_LIBRARY_ID);
       String LibraryID =  inputHandler.readLine();

    }
}
