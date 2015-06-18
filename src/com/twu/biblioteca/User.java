package com.twu.biblioteca;

public class User {
    String name;
    String email;
    int phone;
   private final String libraryID;
    int userType =0;

    public User(String name, String email, int phone, String libraryID ,int userType) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.libraryID = libraryID;
        this.userType  = userType;
    }
    public String getLibraryID(){
        return libraryID;
    }
    public int getUserType() {
        return userType;
    }
    @Override
    public String toString() {
        return "Name : " + name + " Email : " + email +  " Phone : " + phone + " LibraryID :" + libraryID+"\n";
    }
}
