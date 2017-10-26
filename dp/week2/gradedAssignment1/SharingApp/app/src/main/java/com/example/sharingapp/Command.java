package com.example.sharingapp;

/**
 * Created by diebm on 25/10/17.
 */

/**
 * Superclass of AddUserCommand, EditUserCommand, DeleteUserCommand,
 * AddItemCommand, EditItemCommand, DeleteItemCommand
 */

public abstract class Command {

    private boolean is_executed;

    public Command(){
        is_executed = false;
    }

    public abstract void execute();

    public boolean isExecuted(){
        return is_executed;
    }

    public void setIsExecuted(boolean is_executed) {
        this.is_executed = is_executed;
    }
}
