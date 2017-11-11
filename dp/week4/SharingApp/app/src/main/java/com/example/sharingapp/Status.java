package com.example.sharingapp;

/**
 * Created by diebm on 11/11/17.
 */

public class Status {
    private String availableStatus = "Available";
    private String borrowedStatus = "Borrowed";
    private String status = null;
    public Status() {
        setAvailable();
    }

    public void setAvailable() {
        status = availableStatus;
    }

    public void setBorrowed() {
        status = borrowedStatus;
    }

    public String getStatus() {
        return status;
    }

    public boolean isAvailable() {
        return status == availableStatus;
    }

    public boolean isBorrowed() {
        return status == availableStatus;
    }

}
