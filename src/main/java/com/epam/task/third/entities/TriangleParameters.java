package com.epam.task.third.entities;

public class TriangleParameters {

    private final double perimeter;
    private final double area;

    public TriangleParameters(double perimeter, double area) {
        this.perimeter = perimeter;
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TriangleParameters)) return false;
        TriangleParameters that = (TriangleParameters) o;
        return Double.compare(that.getPerimeter(), getPerimeter()) == 0 &&
                Double.compare(that.getArea(), getArea()) == 0;
    }

    @Override
    public int hashCode() {
        int res = 1;
        res = 31 * res + Double.hashCode(perimeter);
        res = 31 * res + Double.hashCode(area);
        return res;
    }

    @Override
    public String toString() {
        return "TetrahedronParameters{" +
                "volume=" + perimeter +
                ", surfaceArea=" + area +
                '}';
    }

}
