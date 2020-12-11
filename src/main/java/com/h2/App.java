package com.h2;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static int doubleTheNumber(int number) {
        return number << 1;
    }

    private static int add(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
