package com.challenge.easy;

public class Fibonacci {

    public static int getRecursive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("The number must be positive");
        }

        if (number == 0 || number == 1) {
            return number;
        }

        return getRecursive(number - 2) + getRecursive(number - 1);
    }


    public static void main(String... args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "\t->\t" + Fibonacci.getRecursive(i));
        }
    }
}
