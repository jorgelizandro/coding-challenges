package com.challenge.easy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BirthdayCakeCandles {
    // Complete the birthdayCakeCandles function below.
    static int birthdayCakeCandles(int[] arr) {
        final IntStream intStream = Arrays.stream(arr);

        final OptionalInt optionalMax = intStream.max();

        if (optionalMax.isPresent()) {
            final int max = optionalMax.getAsInt();

            return (int) Arrays.stream(arr)
                    .filter(value -> value == max)
                    .count();
        }

        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        final int[] arr = {1,2,3,4,3,2,1};
        birthdayCakeCandles(arr);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = birthdayCakeCandles(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
