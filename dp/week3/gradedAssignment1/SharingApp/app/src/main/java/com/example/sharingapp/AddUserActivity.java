package com.example.sharingapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Add a new contact
 */
public class AddUserActivity extends AppCompatActivity implements Observer {

    private UserList user_list = new UserList();
    private UserListController user_list_controller = new UserListController(user_list);

    private Context context;

    private EditText username;
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);

        user_list_controller.addObserver(this);

        context = getApplicationContext();
        user_list_controller.loadUsers(context);
    }

    public void saveUser(View view) {

        String username_str = username.getText().toString();
        String email_str = email.getText().toString();

        if (username_str.equals("")) {
            username.setError("Empty field!");
            return;
        }

        if (email_str.equals("")) {
            email.setError("Empty field!");
            return;
        }

        for (User u : user_list_controller.getUsers()) {
            if (u.getUsername().equals(username_str)) {
                username.setError("Username already taken!");
                return;
            }
        }

        User user = new User(username_str, email_str, null);

        // Add User
        boolean success = user_list_controller.addUser(user, context);
        if (!success) {
            return;
        }

        user_list_controller.removeObserver(this);

        // End AddUserActivity
        finish();
    }

    public void update() {
        // Not much to update here
    }
}
