package com.twu.biblioteca;

public class MainMenuForLibrary {

   OutputHandler outputHandler;
    MainMenuForLibrary(OutputHandler outputHandler){
        this.outputHandler = outputHandler;
    }
    public void start() {
        outputHandler.display(Messages.MAIN_MENU_OPTIONS);
    }
}
