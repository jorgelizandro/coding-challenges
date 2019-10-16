package com.challenge.easy;

public class Factorial {
    private Factorial() {

    }

    public static int getFactorial(int value) {
        if (value < 0) {
            throw new NumberFormatException("Negative numbers are not allowed");
        }

        if (value == 0) {
            return 1;
        }

        return value * getFactorial(value - 1);
    }

    public static void main(String... args) {
        System.out.println(getFactorial(1));    //1
        System.out.println(getFactorial(2));    //2
        System.out.println(getFactorial(3));    //6
        System.out.println(getFactorial(4));    //24
        System.out.println(getFactorial(5));    //120
    }
}
