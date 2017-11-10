package com.example.sharingapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Item class
 */
public class Item extends Observable {

    private String title;
    private String maker;
    private String description;
    private Dimensions dimensions;
    private String status;
    private User borrower;
    protected transient Bitmap image; // Must be transient or app crashes...
    // https://forum.xda-developers.com/android/help/help-android-native-crash-debugging-t3477559
    protected String image_base64;
    private String id;

    public Item(String title, String maker, String description, Bitmap image, String id) {
        this.title = title;
        this.maker = maker;
        this.description = description;
        this.dimensions = null;
        this.status = "Available";
        this.borrower = null;
        addImage(image);

        if (id == null){
            setId();
        } else {
            updateId(id);
        }
    }

    public String getId(){
        return this.id;
    }

    public void setId() {
        this.id = UUID.randomUUID().toString();
        notifyObservers();
    }

    public void updateId(String id){
        this.id = id;
        notifyObservers();
    }

    public void setTitle(String title) {
        this.title = title;
        notifyObservers();
    }

    public String getTitle() {
        return title;
    }

    public void setMaker(String maker) {
        this.maker = maker;
        notifyObservers();
    }

    public String getMaker() {
        return maker;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyObservers();
    }

    public String getDescription() {
        return description;
    }

    public void setDimensions(String length, String width, String height) {
        this.dimensions = new Dimensions(length, width, height);
        notifyObservers();
    }

    public String getLength(){
        return dimensions.getLength();
    }

    public String getWidth(){
        return dimensions.getWidth();
    }

    public String getHeight(){
        return dimensions.getHeight();
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    public String getStatus() {
        return status;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
        notifyObservers();
    }

    public User getBorrower() {
        return borrower;
    }

    public void addImage(Bitmap new_image){
        if (new_image != null) {
            image = new_image;
            ByteArrayOutputStream byteArrayBitmapStream = new ByteArrayOutputStream();
            new_image.compress(Bitmap.CompressFormat.PNG, 100, byteArrayBitmapStream);

            byte[] b = byteArrayBitmapStream.toByteArray();
            image_base64 = Base64.encodeToString(b, Base64.DEFAULT);
        }
        notifyObservers();
    }

    public Bitmap getImage(){
        if (image == null && image_base64 != null) {
            byte[] decodeString = Base64.decode(image_base64, Base64.DEFAULT);
            image = BitmapFactory.decodeByteArray(decodeString, 0, decodeString.length);
            notifyObservers();
        }
        return image;
    }
}

