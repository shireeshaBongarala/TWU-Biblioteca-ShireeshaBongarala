package com.twu.biblioteca;

import java.util.HashMap;

public class Authentication {

    private HashMap<String,String> userList;
    private HashMap<String,String> librarianList;
    private int userState = 0;


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

}
