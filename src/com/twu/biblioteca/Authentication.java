package com.twu.biblioteca;

import java.util.HashMap;

public class Authentication {

    private HashMap<String,String> libraryIdPasswordMap;


    public boolean validate(String libraryId, String password) {
        libraryIdPasswordMap = new HashMap<String, String>();
        libraryIdPasswordMap.put("123-4567","password123");


        if(!libraryIdPasswordMap.containsKey(libraryId))
            return false;

        String passwordFromMap = libraryIdPasswordMap.get(libraryId);
        if(passwordFromMap.equals(password))
            return true;
        return false;
    }

}
