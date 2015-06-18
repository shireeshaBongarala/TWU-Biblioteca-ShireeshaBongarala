package com.twu.biblioteca;

import static com.twu.biblioteca.Messages.*;

public class Login {
    OutputHandler outputHandler;
    InputHandler inputHandler;
    String libraryID, password;
    Authentication authentication;

    Login(OutputHandler outputHandler, InputHandler inputHandler,Authentication authentication) {
        this.outputHandler = outputHandler;
        this.inputHandler = inputHandler;
        this.authentication = authentication;
    }

    public User performAction(User user) {
        inputHandler.readLine();
        outputHandler.display(ENTER_LIBRARY_ID);
        libraryID = inputHandler.readLine();
        outputHandler.display(ENTER_PASSWORD);
        password = inputHandler.readLine();
        if(authentication.validate(libraryID,password)){
            return authentication.getUser(libraryID);
        }
        return user;
    }


}
