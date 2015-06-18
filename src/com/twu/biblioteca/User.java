package com.twu.biblioteca;

public class User {
    String name;
    String email;
    int phone;
   private final String libraryID;

    public User(String name, String email, int phone, String libraryID) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.libraryID = libraryID;
    }
    public String getLibraryID(){
        return libraryID;
    }
    @Override
    public String toString() {
        return "Name : " + name + " Email : " + email +  " Phone : " + phone + " LibraryID :" + libraryID;
    }
}
