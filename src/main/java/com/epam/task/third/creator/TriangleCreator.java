package com.epam.task.third.creator;


import com.epam.task.third.data.DataException;
import com.epam.task.third.data.DataReader;
import com.epam.task.third.entities.Triangle;

import java.util.ArrayList;
import java.util.List;

public class TriangleCreator {

    private DataReader dataReader;
    private TriangleValidator validator;
    private TriangleParser parser;

    public TriangleCreator(DataReader dataReader, TriangleValidator validator, TriangleParser parser) {
        this.dataReader = dataReader;
        this.validator = validator;
        this.parser = parser;
    }

    public List<Triangle> procces(String filename) throws DataException {
        List<String> stringList = dataReader.readFile(filename);
        List<Triangle> tempTriangleArray = new ArrayList<>();

        for (String str: stringList) {
            if(validator.validate(str)){
                tempTriangleArray.add(parser.parseString(str));
            }
        }

        return tempTriangleArray;
    }
}
