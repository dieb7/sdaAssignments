package com.example.sharingapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by diebm on 08/10/17.
 */

public class UserAdapter extends ArrayAdapter<User> {
    private LayoutInflater inflater;
    private Fragment fragment;

    public UserAdapter(Context context, ArrayList<User> users, Fragment fragment) {
        super(context, 0, users);
        inflater = LayoutInflater.from(context);
        this.fragment = fragment;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        User user = getItem(position);
        String username = "Username: " + user.getUsername();
        String email = "Email: " + user.getEmail();
//        Bitmap thumbnail = item.getImage();
//        String status = "Status: " + item.getStatus();

        // Check if an existing view is being reused, otherwise inflate the view.
        if (convertView == null) {
            convertView = inflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

//        TextView username_tv = (TextView) convertView.findViewById(R.id.username_tv);
//        TextView status_tv = (TextView) convertView.findViewById(R.id.status_tv);
//        TextView email_tv = (TextView) convertView.findViewById(R.id.email_tv);
//        ImageView photo = (ImageView) convertView.findViewById(R.id.image_view);

//        if (thumbnail != null) {
//            photo.setImageBitmap(thumbnail);
//        } else {
//            photo.setImageResource(android.R.drawable.ic_menu_gallery);
//        }

//        username_tv.setText(username);
//        email_tv.setText(email);

//        // If AllItemFragments, list_item shows title, description and status
//        if (fragment instanceof AllItemsFragment ) {
//            status_tv.setText(status);
//        }
//
//        // If BorrowedItemsFragments, list_item shows title and description only
//        if (fragment instanceof BorrowedItemsFragment || fragment instanceof AvailableItemsFragment) {
//            status_tv.setVisibility(View.GONE);
//        }

        return convertView;
    }
}
