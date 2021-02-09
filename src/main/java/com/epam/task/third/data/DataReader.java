package com.epam.task.third.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataReader {
    private String inputFileName;

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(DataReader.class));

    public DataReader() {}

    public List<String> readFile(String inputFileName) throws DataException {
        List<String> stringList = new ArrayList<>();
        try {
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            String line;
            while ((line = reader.readLine()) != null) {
                stringList.add(line);
            }
        }
        catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            throw new DataException(e.getMessage(), e);
        }
        LOGGER.info("Успешное чтение из файла");
        return stringList;
    }

    public String getInputFileName() {
        return inputFileName;
    }
}
