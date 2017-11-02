package com.example.sharingapp;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by diebm on 01/11/17.
 */

public class UserListController {
    UserList user_list;

    public UserListController(UserList user_list) {
        this.user_list = user_list;
    }

    public void setUsers(ArrayList<User> user_list) {
        this.user_list.setUsers(user_list);
    }

    public ArrayList<User> getUsers() {
        return this.user_list.getUsers();
    }

    public boolean addUser(User user, Context context) {
        AddUserCommand add_user_command = new AddUserCommand(user_list, user, context);
        add_user_command.execute();
        return add_user_command.isExecuted();
    }

    public boolean deleteUser(User user, Context context) {
        DeleteUserCommand delete_user_command = new DeleteUserCommand(user_list, user, context);
        delete_user_command.execute();
        return delete_user_command.isExecuted();
    }

    public boolean editUser(User user, User updated_user, Context context) {
        EditUserCommand edit_user_command = new EditUserCommand(user_list, user, updated_user, context);
        edit_user_command.execute();
        return edit_user_command.isExecuted();
    }

    public User getUser(int index) {
        return user_list.getUser(index);
    }

    public boolean hasUser(User user) {
        return user_list.hasUser(user);
    }

    public int getIndex(User user) {
        return user_list.getIndex(user);
    }

    public int getSize() {
        return user_list.getSize();
    }

    public void loadUsers(Context context) {
        user_list.loadUsers(context);
    }

    public void addObserver(Observer observer) {
        user_list.addObserver(observer);
    }

    public void removeObserver(Observer observer) {
        user_list.removeObserver(observer);
    }
}
