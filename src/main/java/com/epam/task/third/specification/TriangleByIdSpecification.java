package com.epam.task.third.specification;

import com.epam.task.third.entities.Triangle;

public class TriangleByIdSpecification implements TriangleSpecification{

    private final Integer id;

    public TriangleByIdSpecification(Integer id) {
        this.id = id;
    }

    @Override
    public boolean isSpecified(Triangle triangle) {
        return id.equals(triangle.getId());
    }
}
