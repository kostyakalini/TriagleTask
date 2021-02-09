package com.epam.task.third.repository;

public class IdGenerator {
    public static final Integer BEGIN = 0;

    private Integer id;

    public IdGenerator(Integer start) {
        this.id = start;
    }

    public IdGenerator() {
        this.id = BEGIN;
    }

    public Integer getNextId() {
        return id++;
    }
}
