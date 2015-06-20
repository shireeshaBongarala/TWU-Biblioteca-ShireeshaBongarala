package com.twu.biblioteca;

public interface Messages {
    public String WELCOME_MESSAGE = "Welcome to Biblioteca Library Management System\n";
    public String ERROR_MESSAGE = "Select a valid option!\n";
    public String QUIT_MESSAGE = "Thank you\n";
    public String SUCCESSFUL_BOOK_CHECKOUT = "Thank you! Enjoy the Book.\n";
    public String THAT_BOOK_IS_NOT_AVAILABLE = "That book is not available\n";
    public String ENTER_BOOK_NAME = "Enter the Book name for Check out.:\n";
    public String ENTER_BOOK_NAME_FOR_RETURNING = "Enter Book name ";
    public String SUCCESSFUL_BOOK_RETURN = "Thank you for returning the book\n";
    public String UNSUCCESSFUL_BOOK_RETURN = "This is not a valid book to return\n";
    public String ENTER_MOVIE_NAME = "Enter the movie name.:\n";

    public String SUCCESSFUL_MOVIE_CHECKOUT = "Thank you! Enjoy the movie.\n";
    public String THAT_MOVIE_IS_NOT_AVAILABLE = "That movie is not avaialable\n";
    public String SUCCESSFUL_MOVIE_RETURN = "Thank you for returning the movie\n";
    public String UNSUCCESSFUL_MOVIE_RETURN = "This is not a valid movie to return\n";

    public String MAIN_MENU_OPTIONS = "Select Choice:\n1. Book List\n2. Movie List \n3. Login \n4. Quit\n";
    public String ENTER_LIBRARY_ID = "Enter Library ID :";
    public String ENTER_PASSWORD = "Enter Password :";
    public String MAIN_MENU_FOR_LOGGEDIN_USER = "Select choice:\n1.Book List\n2.Movie List\n3.Checkout Book\n" +
            "4.Return Book\n5.Checkout Movie\n6.Return Movie\n7.About user\n8.Logout\n";
    public String MAIN_MENU_FOR_LIBRARIAN = "Select choice:\n1.Book List\n2.Movie List\n3.CheckedOutItemsHistory\n4.About user\n5.Logout\n";
    public String ENTER_YOUR_CHOICE = "Enter your choice :";
}