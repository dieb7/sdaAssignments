package com.example.sharingapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EditUserActivity extends AppCompatActivity {

    private EditText email;

    private UserList user_list = new UserList();

    private Context context;

    private User user;

    private TextView userNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        email = (EditText) findViewById(R.id.contactNewEmailtextEdit);

        context = getApplicationContext();

        // We don't get a reference to an existing userlist object, we create one an load its contents
        user_list.loadUsers(context);

        userNameTextView = (TextView) findViewById(R.id.contactNameTextView);
        // get intent from parent activity
        Intent intent = getIntent();
        int pos = intent.getIntExtra("position", 0);

        user = user_list.getUser(pos);

        userNameTextView.setText(user.getUsername());
    }

    public void saveEditedUser(View view) {
        String email_str = email.getText().toString();

        if (email_str.equals("")) {
            email.setError("Empty field!");
            return;
        }

        user.setEmail(email_str);

        user_list.saveUsers(context);

        /* End EditUserActivity */
        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);
    }

    public void deleteUser(View view) {
        user_list.removeUser(user);

        user_list.saveUsers(context);

        /* End EditUserActivity */
        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);
    }
}
