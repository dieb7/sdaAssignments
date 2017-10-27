package com.example.sharingapp;

import android.content.Context;

/**
 * Created by dieb7 on 26/10/17.
 */

public class DeleteUserCommand extends Command {
    private UserList user_list;
    private User user;
    private Context context;

    public DeleteUserCommand(UserList user_list, User user, Context context) {
        this.user_list = user_list;
        this.user = user;
        this.context = context;

    }

    public void execute() {
        user_list.removeUser(user);
        user_list.saveUsers(context);
        setIsExecuted(true);
    }
}
