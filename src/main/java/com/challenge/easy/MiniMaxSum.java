package com.challenge.easy;

import java.util.Arrays;
import java.util.Scanner;

public class MiniMaxSum {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(final int[] arr) {
        if (arr == null || arr.length != 5) {
            return;
        }

        final int[] sortedArr = Arrays.stream(arr)
                .sorted()
                .toArray();

        long min = 0;
        long max = 0;
        for (int i = 0; i < 4; i++) {
            min += sortedArr[i];
            max += sortedArr[sortedArr.length - i - 1];
        }

        System.out.println(min + " " + max);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
