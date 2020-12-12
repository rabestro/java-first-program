package com.h2;

public class Utilities {
    public static long getLongValue(final String in) {
        var out = Long.MIN_VALUE;
        try {
            out = Long.parseLong(in);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(in + " cannot be converted into a 'long' value. Exiting program.");
        }
        return out;
    }
}