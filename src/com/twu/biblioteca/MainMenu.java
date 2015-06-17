package com.twu.biblioteca;

import static com.twu.biblioteca.Messages.*;

public class MainMenu {
    OutputHandler outputHandler;
    MainMenu(OutputHandler outputHandler){
        this.outputHandler = outputHandler;
    }
    public void displayOptions() {
        outputHandler.display(MAIN_MENU_OPTIONS);
    }
}
