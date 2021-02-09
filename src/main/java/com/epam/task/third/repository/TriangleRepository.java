package com.epam.task.third.repository;

import com.epam.task.third.entities.Triangle;
import com.epam.task.third.specification.TriangleSpecification;

import java.util.List;

public interface TriangleRepository {
    void addTriangle(Triangle tetrahedron);
    void updateTriangle(Triangle tetrahedron);
    void removeTriangle(Triangle tetrahedron);

    List<Triangle> processQuery(TriangleSpecification specification);
}
