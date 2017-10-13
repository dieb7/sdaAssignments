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
    private Context context;
    ArrayList<User> users;

    public UserAdapter(Context context, ArrayList<User> users) {
        super(context, 0, users);
        this.context = context;
        this.users = users;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.contactrow, parent, false);

        TextView userNameTextView = (TextView) rowView.findViewById(R.id.contactName);
        TextView emailTextView = (TextView) rowView.findViewById(R.id.contactEmail);

        userNameTextView.setText(users.get(position).getUsername());
        emailTextView.setText(users.get(position).getEmail());

        return rowView;
    }
}
