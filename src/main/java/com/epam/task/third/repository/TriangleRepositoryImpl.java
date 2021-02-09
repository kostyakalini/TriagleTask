package com.epam.task.third.repository;

import com.epam.task.third.entities.Triangle;
import com.epam.task.third.specification.TriangleSpecification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TriangleRepositoryImpl implements TriangleRepository{

    private final Map<Integer, Triangle> triangleMap = new HashMap<>();

    @Override
    public void addTriangle(Triangle triangle) {
        Integer id = triangle.getId();
        triangleMap.put(id, triangle);
    }

    @Override
    public void updateTriangle(Triangle triangle) {
        Integer id = triangle.getId();
        triangleMap.replace(id, triangle);
    }

    @Override
    public void removeTriangle(Triangle triangle) {
        Integer id = triangle.getId();
        triangleMap.remove(id);
    }

    @Override
    public List<Triangle> processQuery(TriangleSpecification specification) {
        List<Triangle> tetrahedrons = new ArrayList<>();
        for (Triangle tetrahedron : triangleMap.values()) {
            if (specification.isSpecified(tetrahedron)) {
                tetrahedrons.add(tetrahedron);
            }
        }
        return tetrahedrons;
    }
}
