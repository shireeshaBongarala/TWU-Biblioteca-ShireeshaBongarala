package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class Authentication {

    private HashMap<String,String> userList;
    private HashMap<String,String> librarianList;
    ArrayList<User> userArrayList;
    private int userState = 0;

    Authentication(){
        userArrayList = new ArrayList<User>();
        userArrayList.add(new User("shireesha","shiree@gmail.com",1233456,"123-4567",1));
        userArrayList.add(new User("manohar","manu@gmail.com",123456,"000-0123",2));
    }

    public boolean validate(String libraryId, String password) {
        userList = new HashMap<String, String>();
        userList.put("123-4567","password123");


        if(!userList.containsKey(libraryId))
            return validateLibrarian(libraryId,password);

        String passwordFromMap = userList.get(libraryId);
        if(passwordFromMap.equals(password)){
            userState = 1;
            return true;
        }
        return false;
    }
    public boolean validateLibrarian(String librayId,String password) {
        librarianList = new HashMap<String,String>();
        librarianList.put("000-0123","password123");
        
        if(!librarianList.containsKey(librayId))
            return false;
        String passwordFromMap = librarianList.get(librayId);
            if(passwordFromMap.equals(password)){
                userState = 2;
                return true;}
        return false;
    }

    public int getUserState(){
        return userState;
    }
    public User getUser(String libraryId) {
        for(User user : userArrayList){
            if(user.getLibraryID().equals(libraryId)){
                return user;
            }
        }
        return null;
    }

}
