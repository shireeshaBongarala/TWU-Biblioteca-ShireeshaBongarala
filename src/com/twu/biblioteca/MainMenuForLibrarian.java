package com.twu.biblioteca;

import static com.twu.biblioteca.Messages.*;

public class MainMenuForLibrarian {
    OutputHandler outputHandler;
    public MainMenuForLibrarian(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;
    }

    public void start() {
        outputHandler.display(MAIN_MENU_FOR_LIBRARIAN);
    }
}
