package com.example.sharingapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class ContactsActivity extends AppCompatActivity {
    private UserList user_list;
    private UserList active_borrowers_list;
    private ItemList item_list;
    private ListView my_contacts;
    private ArrayAdapter<User> adapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        item_list = new ItemList();
        item_list.loadItems(getApplicationContext());

        // Find the listView resource
        my_contacts = (ListView) findViewById(R.id.contacts_lv);

        user_list = new UserList();
        user_list.loadUsers(getApplicationContext());

        adapter = new UserAdapter(this, user_list.getUsers());

        my_contacts.setAdapter(adapter);

        context = this;

        // When User is long clicked, this starts EditUserActivity
        my_contacts.setOnItemLongClickListener(new android.widget.AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int pos, long id) {

                User user = adapter.getItem(pos);

                boolean user_is_borrower = false;

                for (Item i: item_list.getItems()) {
                    if (user.getUsername().equals(i.getBorrower().getUsername())) {
                        user_is_borrower = true;
                    }
                }

                if (!user_is_borrower) {
                    int meta_pos = user_list.getIndex(user);

                    if (meta_pos >= 0) {
                        Intent edit = new Intent(context, EditUserActivity.class);
                        edit.putExtra("position", meta_pos);
                        startActivity(edit);
                    }
                } else {
                    // show that user can not be edited as it is and active borrower
                    AlertDialog alert_dialog = new AlertDialog.Builder(ContactsActivity.this).create();
                    alert_dialog.setTitle("Contact is a borrower");
                    alert_dialog.setMessage("Can not edit an active borrower!");
                    alert_dialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alert_dialog.show();



//                    ((TextView) findViewById(R.id.contact_name)).setError("Can't Edit a borrower!");
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
