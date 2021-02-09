package com.epam.task.third.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

    private List<Point> coordinates;
    private Integer id;

    public Triangle(Point one, Point two, Point three) {
        this.coordinates = Arrays.asList(one, two, three);
    }

    public Triangle(Integer id, List<Point> coordinates) {
        this.coordinates = coordinates;
        this.id = id;
    }

    public Triangle(Integer id, Point... points) {
        this.coordinates = new ArrayList<>(Arrays.asList(points));
        this.id = id;
    }

    public List<Point> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Point> coordinates) {
        this.coordinates = coordinates;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return getCoordinates().equals(triangle.getCoordinates()) &&
                getId().equals(triangle.getId());
    }

    @Override
    public int hashCode() {
        int res = 1;
        res = 31 * res + (coordinates == null ? 0 : coordinates.hashCode());
        res = 31 * res + Double.hashCode(id);
        return res;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "coordinates=" + coordinates +
                ", id=" + id +
                '}';
    }
}
