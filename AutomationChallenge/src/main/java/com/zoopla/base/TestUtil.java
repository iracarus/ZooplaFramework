package com.zoopla.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.StrictMath.max;

public class TestUtil {
    public static final int PAGE_LOAD_TIMEOUT = 20;
    public static final int IMPLICITLY_WAIT = 10;

    // Method to extract the maximum value
    public static int getNumeric(String str)
    {
        String string;
        string = str.replaceAll("[^0-9]", "");
        return Integer.parseInt(string);
    }
}
