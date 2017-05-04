package com.mdx.mars.robot.utils;

import java.util.Arrays;
import java.util.List;

public class StringUtils {
    
    public static List<String> getListFromString(String text) {
        String[] splitedString = text.split("");

        return Arrays.asList(splitedString);
    }
}
