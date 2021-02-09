package com.epam.task.third.observer;

import com.epam.task.third.entities.TriangleParameters;
import com.epam.task.third.logic.TriangleCharacteristicsCalculator;

import java.util.HashMap;
import java.util.Map;

public class TriangleObserver implements Observer {

    private static TriangleObserver instance;

    private final TriangleCharacteristicsCalculator calculator;
    private final Map<Integer, TriangleParameters> parameters;

    private TriangleObserver() {
        calculator = new TriangleCharacteristicsCalculator();
        parameters = new HashMap<>();
    }

    public static TriangleObserver getInstance() {
        if (instance == null) {
            instance = new TriangleObserver();
        }
        return instance;
    }

    @Override
    public void update(TriangleObservable triangleObservable) {
        TriangleParameters params = calculateTetrahedronParameters(triangleObservable);
        parameters.put(triangleObservable.getId(), params);
    }

    private TriangleParameters calculateTetrahedronParameters(TriangleObservable triangleObservable) {
        double perimeter = calculator.findPerimeter(triangleObservable);
        double area = calculator.findArea(triangleObservable);
        return new TriangleParameters(perimeter, area);
    }

    public double getTrianglePerimeter(Integer id) {
        TriangleParameters triangleParameters = parameters.get(id);
        return triangleParameters.getPerimeter();
    }

    public double getTriangleArea(Integer id) {
        TriangleParameters triangleParameters = parameters.get(id);
        return triangleParameters.getArea();
    }
}
