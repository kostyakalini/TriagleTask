package com.epam.task.third.creator;

import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Triangle;
import com.epam.task.third.repository.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class TriangleParser {

    private final IdGenerator idGenerator = new IdGenerator();
    public TriangleParser() {}

    public Triangle parseString(String line){
        String[] numberStrings = line.split(" ");
        List<Double> numbers = new ArrayList<>();
        for (String str : numberStrings) {
            Double temp = Double.parseDouble(str);
            numbers.add(temp);
        }
        Point firstPoint = new Point(numbers.get(0), numbers.get(1));
        Point secondPoint = new Point(numbers.get(2), numbers.get(3));
        Point thirdPoint = new Point(numbers.get(4), numbers.get(5));
        Integer id = idGenerator.getNextId();
        return new Triangle(id, firstPoint, secondPoint, thirdPoint);
    }
}
