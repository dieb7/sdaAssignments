package com.example.sharingapp;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by diebm on 10/10/17.
 */

public class UserList {
    private static ArrayList<User> users;
    private String FILENAME = "user_file.sav";

    public UserList() {
        users = new ArrayList<User>();
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<String> getAllUsernames() {
        ArrayList<String> usernames = new ArrayList<String>();
        for (User u : users) {
            usernames.add(u.getUsername());
        }
        return usernames;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public User getUser(int index) {
        return users.get(index);
    }

    public int getSize() {
        return users.size();
    }

    public int getIndex(User user) {
        int pos = 0;
        for (User u : users) {
            if (user.getUsername().equals(u.getUsername())) {
                return pos;
            }
            pos = pos+1;
        }
        return -1;
    }

    public boolean hasUser(User user) {
        for (User u : users) {
            if (user.getUsername().equals(u.getUsername())) {
                return true;
            }
        }
        return false;
    }

    public User getUserByUsername(String username) {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }

    public void loadUsers(Context context) {
        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            InputStreamReader isr = new InputStreamReader(fis);
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<User>>() {}.getType();
            users = gson.fromJson(isr, listType); // temporary
            fis.close();
        } catch (FileNotFoundException e) {
            users = new ArrayList<User>();
        } catch (IOException e) {
            users = new ArrayList<User>();
        }
    }

    public void saveUsers(Context context) {
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME, 0);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(users, osw);
            osw.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean isUserNameAvailable(String username) {
        if (getUserByUsername(username) == null) {
            return true;
        }
        return false;
    }
}
