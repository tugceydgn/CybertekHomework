package com.cbt.utilities;

public class StringUtility {
    public static boolean verifyEquals(String expected, String actual) {


        if (expected.equals(actual)) {
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
            System.out.println("PASSED");

            return true;
        } else {
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
            System.out.println("FAILED");
            return false;
        }


    }

}
