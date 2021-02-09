package com.epam.task.third.logic;

import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Triangle;

import java.util.ArrayList;
import java.util.List;

public class TriangleCharacteristicsCalculator {

    public TriangleCharacteristicsCalculator() {
    }

    private List<Double> calculateSides(List<Point> points){
        Point firstPoint = points.get(0);
        Point secondPoint = points.get(1);
        Point thirdPoint = points.get(2);
        List<Double> sides = new ArrayList<>();
        Double firstSide = Math.sqrt(Math.pow(firstPoint.getX() - secondPoint.getX(), 2) +
                Math.pow(firstPoint.getY() - secondPoint.getY(), 2));
        sides.add(firstSide);
        Double secondSide = Math.sqrt(Math.pow(firstPoint.getX() - thirdPoint.getX(), 2) +
                Math.pow(firstPoint.getY() - thirdPoint.getY(), 2));
        sides.add(secondSide);
        Double thirdSide = Math.sqrt(Math.pow(secondPoint.getX() - secondPoint.getX(), 2) +
                Math.pow(secondPoint.getY() - secondPoint.getY(), 2));
        sides.add(thirdSide);
        return sides;
    }

    public double findPerimeter(Triangle triangle) {
        List<Point> points = triangle.getCoordinates();
        List<Double> sides = calculateSides(points);
        return sides.get(0) + sides.get(1) + sides.get(2);
    }

    public double findArea(Triangle triangle) {
        List<Point> points = triangle.getCoordinates();
        List<Double> sides = calculateSides(points);
        Double semiPerimeter = (sides.get(0) + sides.get(1) + sides.get(2)) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - sides.get(0)) *
                (semiPerimeter - sides.get(1)) *
                (semiPerimeter - sides.get(2)));
    }

    public boolean isTriangleValid(Triangle triangle) {
        List<Point> points = triangle.getCoordinates();
        Point firstPoint = points.get(0);
        Point secondPoint = points.get(1);
        Point thirdPoint = points.get(2);
        return Math.abs(firstPoint.getX() - secondPoint.getX()) * Math.abs(thirdPoint.getX() - secondPoint.getX()) -
                Math.abs(thirdPoint.getX() - secondPoint.getX()) * Math.abs(firstPoint.getX() - secondPoint.getX()) == 0;
    }

    public boolean isTriangleRight(Triangle triangle) {
        List<Point> points = triangle.getCoordinates();
        List<Double> sides = calculateSides(points);
        boolean right = false;
        double sqrtFirstSide = Math.sqrt(sides.get(0));
        double sqrtSecondSide = Math.sqrt(sides.get(1));
        double sqrtThirdSide = Math.sqrt(sides.get(2));
        if(sqrtFirstSide + sqrtSecondSide == sqrtThirdSide){
            right = true;
        }
        else if(sqrtFirstSide + sqrtThirdSide == sqrtSecondSide){
            right = true;
        }
        else if(sqrtSecondSide + sqrtThirdSide == sqrtFirstSide){
            right = true;
        }
        return right;
    }

    public boolean isTriangleEquilateral(Triangle triangle) {
        List<Point> points = triangle.getCoordinates();
        List<Double> sides = calculateSides(points);
        return sides.get(0).equals(sides.get(1)) && sides.get(0).equals(sides.get(2));
    }

    public boolean isTriangleIsosceles(Triangle triangle) {
        List<Point> points = triangle.getCoordinates();
        List<Double> sides = calculateSides(points);
        return sides.get(0).equals(sides.get(1)) ||
                sides.get(0).equals(sides.get(2)) ||
                sides.get(1).equals(sides.get(2));
    }


    public boolean isTriangleObtuse(Triangle triangle) {
        List<Point> points = triangle.getCoordinates();
        List<Double> sides = calculateSides(points);
        boolean obtuse = false;
        double sqrtFirstSide = Math.sqrt(sides.get(0));
        double sqrtSecondSide = Math.sqrt(sides.get(1));
        double sqrtThirdSide = Math.sqrt(sides.get(2));
        if(sqrtFirstSide + sqrtSecondSide > sqrtThirdSide){
            obtuse = true;
        }
        else if(sqrtFirstSide + sqrtThirdSide > sqrtSecondSide){
            obtuse = true;
        }
        else if(sqrtSecondSide + sqrtThirdSide > sqrtFirstSide){
            obtuse = true;
        }
        return obtuse;
    }

    public boolean isTriangleAcute(Triangle triangle) {
        List<Point> points = triangle.getCoordinates();
        List<Double> sides = calculateSides(points);
        boolean acute = false;
        double sqrtFirstSide = Math.sqrt(sides.get(0));
        double sqrtSecondSide = Math.sqrt(sides.get(1));
        double sqrtThirdSide = Math.sqrt(sides.get(2));
        if(sqrtFirstSide + sqrtSecondSide < sqrtThirdSide){
            acute = true;
        }
        else if(sqrtFirstSide + sqrtThirdSide < sqrtSecondSide){
            acute = true;
        }
        else if(sqrtSecondSide + sqrtThirdSide < sqrtFirstSide){
            acute = true;
        }
        return acute;
    }




}

