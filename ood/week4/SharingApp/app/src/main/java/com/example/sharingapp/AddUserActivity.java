package com.example.sharingapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddUserActivity extends AppCompatActivity {

    private EditText username;
    private EditText email;

    private Context context;

    private UserList user_list = new UserList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        username = (EditText) findViewById(R.id.contactNameEditText);
        email = (EditText) findViewById(R.id.contactEmailEditText);

        context = getApplicationContext();

        // We don't get a reference to an existing userlist object, we create one an load its contents
        user_list.loadUsers(context);
    }

    public void saveUser(View view) {
        String username_str = username.getText().toString();
        String email_str = email.getText().toString();

        if (username_str.equals("")) {
            username.setError("Empty field!");
            return;
        }

        if (!user_list.isUserNameAvailable(username_str)) {
            username.setError("Username already exists!");
            return;
        }

        if (email_str.equals("")) {
            email.setError("Empty field!");
            return;
        }

        // TODO: pass id to User here
        User user = new User(username_str, email_str, "");

        user_list.addUser(user);
        user_list.saveUsers(context);

        /* End AddUserActivity */
        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);
    }
}
