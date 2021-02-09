package com.epam.task.third.data;

import java.io.IOException;

public class DataException extends IOException {

    public DataException(String message, IOException e){
        super(message);
    }

}
