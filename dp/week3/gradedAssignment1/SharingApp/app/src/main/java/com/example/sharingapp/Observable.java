package com.example.sharingapp;

import java.util.ArrayList;

/**
 * Created by diebm on 01/11/17.
 */

public class Observable {
    private ArrayList<Observer> observers;
    public Observable() {
        observers = new ArrayList<Observer>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer: observers) {
            observer.update();
        }
    }
}
