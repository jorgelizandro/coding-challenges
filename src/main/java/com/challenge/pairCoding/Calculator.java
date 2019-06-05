package com.challenge.pairCoding;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * Given a collection of numbers write a Java program to calculate the sum and product of all even numbers.
 * How can the program be changed to support a general aggregation of the numbers (like the sum) selected by a general criterion (like the even numbers).
 */

public final class Calculator {
    private Calculator() {
        //NOOP
    }

    private static <T> T performOperation(
            final Predicate<T> predicate,
            final BinaryOperator<T> operation,
            final T... items
    ) {
        if (items == null || items.length == 0) {
            return null;
        }

        T result = null;
        for (final T item : items) {
            if (item != null) {
                if (predicate.test(item)) {
                    result = result == null ? item : operation.apply(result, item);
                }
            }
        }

        return result;
    }


    public static Integer sumEvenNumbers(final Integer... numbers) {
        return performOperation(
                i -> (i % 2 == 0),
                Integer::sum,
                numbers
        );
    }

    public static Integer multiplyEvenNumbers(final Integer... numbers) {
        return performOperation(
                i -> (i % 2 == 0),
                (x, y) -> x * y,
                numbers
        );
    }

    public static void main(final String... args) {
        System.out.println("Sum even numbers: " + sumEvenNumbers(1, 2, 3, 4, 5));
        System.out.println("Multiply even numbers: " + multiplyEvenNumbers(1, 2, 3, 4, 5));

        //Shorter alternative using streams
        IntStream.of(1, 2, 3, 4, 5)
                .filter(x -> x % 2 == 0)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
    }
}
