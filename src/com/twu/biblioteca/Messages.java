package com.twu.biblioteca;

public interface Messages {
    public String WELCOME_MESSAGE = "Welcome to Biblioteca Library Management System\n";
    public String ERROR_MESSAGE = "Select a valid option!\n";
    public String MENU_OPTIONS = "Select Choice:\n1. Book List\n2.Return Book\n3.Movie List\n4.Quit\n";
    public String QUIT_MESSAGE = "Thank you\n";
    public String PROMPT_USER_FOR_CHECKOUT_BOOK = "Would you like to checkout a book?(y/n)\n";
    public String SUCCESSFUL_BOOK_CHECKOUT = "Thank you! Enjoy the Book.\n";
    public String THAT_BOOK_IS_NOT_AVAILABLE = "That book is not available\n";
    public String ENTER_BOOK_NAME = "Enter the Book name for Check out.:\n";
    public String ENTER_BOOK_NAME_FOR_RETURNING = "Enter Book name ";
    public String SUCCESSFUL_BOOK_RETURN = "Thank you for returning the book\n";
    public String UNSUCCESSFUL_BOOK_RETURN = "This is not a valid book to return\n";
    public String PROMPT_USER_FOR_CHECKOUT_MOVIE = "Would you like to checkout a movie?(y/n)\n";
    public String ENTER_MOVIE_NAME = "Enter the movie name for check out.:\n";
    public String SUCCESSFUL_MOVIE_CHECKOUT = "Thank you! Enjoy the movie.\n";
    public String THAT_MOVIE_IS_NOT_AVAILABLE = "That movie is not avaialable\n";
    public String SUCCESSFUL_MOVIE_RETURN = "Thank you for returning the movie\n";
}