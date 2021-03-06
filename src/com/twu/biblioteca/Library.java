package com.twu.biblioteca;

import java.util.ArrayList;

import static com.twu.biblioteca.EntryPoint.*;

public class Library {
    private ArrayList<Book> availableBookList;
    private ArrayList <Book> checkedOutBookList;
    private ArrayList<Movie> availableMovieList;
    private ArrayList<Movie> checkedOutMovieList;
    Library(){
        availableBookList = new ArrayList<Book>();
        checkedOutBookList = new ArrayList<Book>();

        availableMovieList  = new ArrayList<Movie>();
        checkedOutMovieList = new ArrayList<Movie>();

        checkedOutBookList.add(new Book("Let Us C","balagurusamy",1997));

        availableBookList.add(new Book("C-Balagurusamy", "Balagurusamy", 1990));
        availableBookList.add(new Book("C++", "Balagurusamy", 1995));
        availableBookList.add(new Book("Java", "O'Reilly", 2012));

        checkedOutMovieList.add(new Movie("DarkKnight",2009,"Director4",10));

        availableMovieList.add(new Movie("IronMan",2005,"Director1",9));
        availableMovieList.add(new Movie("IronMan2",2007,"Director2",9));
        availableMovieList.add(new Movie("IronMan3",2009,"Director3",9));
    }
    public ArrayList<Book> getAvailableBookList(){
        return availableBookList;
    }
    public ArrayList<Movie> getAvailableMovieList() {
        return availableMovieList;
    }

    public boolean additionToAvailableBookListIsSuccessful(String bookName) {
        for(Book book : checkedOutBookList) {
            if (book.getName().equals(bookName)) {
                availableBookList.add(book);
                checkedOutBookList.remove(book);
                return true;
            }
        }
        return false;
    }
    public boolean additionToCheckedOutBookListIsSuccessful(String bookName) {
        for(Book book : availableBookList){
            if(book.getName().equals(bookName)) {
                checkedOutBookList.add(book);
                bookUserHashMap.put(book,user);
                availableBookList.remove(book);
                return true;
            }
        }
        return false;
    }
    public boolean additionToAvailableMovieListIsSuccessful(String movieName) {
        for(Movie movie : checkedOutMovieList) {
            if (movie.getName().equals(movieName)) {
                availableMovieList.add(movie);
                checkedOutMovieList.remove(movie);
                return true;
            }
        }
        return false;
    }
    public boolean additionToCheckedOutMovieListIsSuccessful(String movieName) {
        for(Movie  movie : availableMovieList){
            if(movie.getName().equals(movieName)) {
                checkedOutMovieList.add(movie);
                movieUserHashMap.put(movie,user);
                availableMovieList.remove(movie);
                return true;
            }
        }
        return false;
    }
}
