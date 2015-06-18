package com.twu.biblioteca;

import java.util.ArrayList;

public class UserInformation {

    ArrayList<User> userList;
    UserInformation(){
        userList = new ArrayList<User>();
        userList.add(new User("shireesha","shiree@gmail.com",1233456,"123-4567"));
        userList.add(new User("manohar","manu@gmail.com",123456,"000-0123"));
    }
    public User getDetails(String libraryId) {
        for(User user : userList){
            if(user.getLibraryID().equals(libraryId)){
                return user;
            }
        }
        return null;
    }
}
