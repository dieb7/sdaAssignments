package com.example.sharingapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.security.AccessControlContext;
import java.util.ArrayList;
import java.util.Arrays;

import static java.security.AccessController.getContext;

public class ContactsActivity extends AppCompatActivity {

    private ListView my_contacts;
    private ArrayAdapter<User> listAdapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        // Find the listView resource
        my_contacts = (ListView) findViewById(R.id.contactsListView);

        // Create and populate a list of users
        final UserList userList = new UserList();

        userList.loadUsers(getApplicationContext());

        listAdapter = new UserAdapter(this, userList.getUsers());

        my_contacts.setAdapter(listAdapter);

        context = this;

        // When User is long clicked, this starts EditUserActivity
        my_contacts.setOnItemLongClickListener(new android.widget.AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int pos, long id) {

                User user = listAdapter.getItem(pos);

                int meta_pos = userList.getIndex(user);

                if (meta_pos >= 0) {

                    Intent edit = new Intent(context, EditUserActivity.class);
                    edit.putExtra("position", meta_pos);
                    startActivity(edit);
                }
                return true;
            }
        });
    }

    public void addUserActivity(View view) {
        Intent intent = new Intent(this, AddUserActivity.class);
        startActivity(intent);
    }

    public void mainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
