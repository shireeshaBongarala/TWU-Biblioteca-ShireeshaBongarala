package com.twu.biblioteca;

import static com.twu.biblioteca.Messages.*;

public class BibliotecaApp {
    int choice;
    OutputHandler outputHandler;
    InputHandler inputHandler;
    Books books;
    ReturnItem returnItem;
    CheckOutItem checkout;
    Library library;
    Movies movies;
    BookListOption bookListOption;
    MovieListOption movieListOption;
    Authentication authentication = new Authentication();

    public BibliotecaApp(OutputHandler outputHandler, InputHandler inputHandler, Books books,
                         ReturnItem returnItem, CheckOutItem checkOutItem, Movies movies) {
        this.outputHandler = outputHandler;
        this.inputHandler = inputHandler;
        this.returnItem = returnItem;
        this.checkout = checkOutItem;
        this.movies = movies;
        this.books = books;
        bookListOption = new BookListOption(outputHandler,checkout);
        movieListOption = new MovieListOption(outputHandler,checkOutItem);
    }

    public void start() {
        outputHandler.display(WELCOME_MESSAGE);
        MainMenuForLibrary mainMenuForLibrary = new MainMenuForLibrary(outputHandler,inputHandler,checkout,books,bookListOption,movieListOption,movies);
        //mainMenuForLibrary.start();
        MainMenuForUsersInLibrary();
    }

    private void MainMenuForUsersInLibrary() {
        do {
            outputHandler.display(MENU_OPTIONS);
            choice = inputHandler.readInteger();

            switch (choice) {
                case 1:
                    bookListOption.performAction(books);
                    break;
                case 2:
                    returnBookOption();
                    break;
                case 3:
                    movieListOption();
                    break;
                case 4:
                    returnMovieOption();
                    break;
                case 5:
                    outputHandler.display(QUIT_MESSAGE);
                    break;
                default:
                    outputHandler.display(ERROR_MESSAGE);
            }

        } while (choice != 5);
    }

    private void returnMovieOption() {
        outputHandler.display(ENTER_MOVIE_NAME);
        returnItem.returnMovie();
    }

    private void movieListOption() {
        promptForCheckingoutMovies();
        if (checkout.isInterestedToCheckOut()) {
            outputHandler.display(ENTER_MOVIE_NAME);
            checkout.checkOutMovie();
        }
    }

    private void returnBookOption() {
        System.out.println("Enter library ID :");
        String libraryId = inputHandler.readLine();
        System.out.println("Enter password :");
        String password = inputHandler.readLine();
        if (authentication.validate(libraryId, password)) {
            outputHandler.display(ENTER_BOOK_NAME_FOR_RETURNING);
            returnItem.returnBook();
        }
    }
    private void promptForCheckingoutMovies() {
        outputHandler.display(movies);
        outputHandler.display(PROMPT_USER_FOR_CHECKOUT_MOVIE);
    }
}
