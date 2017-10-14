package com.example.sharingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by diebm on 10/10/17.
 */

public class UserAdapter extends ArrayAdapter<User> {
    private LayoutInflater inflater;
    private Context context;
    ArrayList<User> users;

    public UserAdapter(Context context, ArrayList<User> users) {
        super(context, 0, users);
        this.context = context;
        this.users = users;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row_view = inflater.inflate(R.layout.contactrow, parent, false);

        TextView username_tv = (TextView) row_view.findViewById(R.id.contact_name);
        TextView email_tv = (TextView) row_view.findViewById(R.id.contact_email);

        username_tv.setText(users.get(position).getUsername());
        email_tv.setText(users.get(position).getEmail());

        return row_view;
    }
}
