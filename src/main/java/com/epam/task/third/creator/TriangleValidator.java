package com.epam.task.third.creator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TriangleValidator {
    public TriangleValidator() {}

    public boolean validate(String line){
        boolean result = false;
        Pattern pattern = Pattern.compile("-?\\d+\\.?\\d*\\s-?\\d+\\.?\\d*" +
                "\\s-?\\d+\\.?\\d*\\s-?\\d+\\.?\\d*" +
                "\\s-?\\d+\\.?\\d*\\s-?\\d+\\.?\\d*");
        Matcher matcher = pattern.matcher(line);
        result = matcher.matches();
        return result;
    }
}
