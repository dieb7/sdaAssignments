package com.example.sharingapp;

/**
 * Created by diebm on 01/11/17.
 */

public class UserController {
    User user;

    public UserController(User user) {
        this.user = user;
    }

    public String getId(){
        return user.getId();
    }

    public void setId() {
        user.setId();
    }

    public void updateId(String id){
        user.updateId(id);
    }

    public String getUsername() {
        return user.getUsername();
    }

    public void setUsername(String username) {
        user.setUsername(username);
    }

    public String getEmail() {
        return user.getEmail();
    }

    public void setEmail(String email) {
        user.setEmail(email);
    }

    public void addObserver(Observer observer) {
        user.addObserver(observer);
    }

    public void removeObserver(Observer observer) {
        user.removeObserver(observer);
    }
}
