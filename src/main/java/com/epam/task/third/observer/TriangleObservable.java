package com.epam.task.third.observer;

import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Triangle;

import java.util.ArrayList;
import java.util.List;

public class TriangleObservable extends Triangle implements Observable {

    private final List<Observer> observers;

    public TriangleObservable(Integer id, Point... points) {
        super(id, points);
        this.observers = new ArrayList<>();
    }

    public TriangleObservable(Integer id, List<Point> points) {
        super(id, points);
        this.observers = new ArrayList<>();
    }


    @Override
    public void setCoordinates(List<Point> coordinates) {
        super.setCoordinates(coordinates);
        notifyObservers();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
