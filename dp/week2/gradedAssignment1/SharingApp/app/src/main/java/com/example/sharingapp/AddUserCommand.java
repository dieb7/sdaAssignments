package com.example.sharingapp;

import android.content.Context;

/**
 * Created by dieb7 on 26/10/17.
 */

public class AddUserCommand extends Command {
    private UserList user_list;
    private User new_user;
    private Context context;

    public AddUserCommand(UserList user_list, User new_user, Context context) {
        this.user_list = user_list;
        this.new_user = new_user;
        this.context = context;
    }

    public void execute() {
        user_list.addUser(new_user);
        user_list.saveUsers(context);
        setIsExecuted(true);
    }
}
