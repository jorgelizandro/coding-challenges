package com.challenge.easy;

public class TwoDArrayDS {
    // Complete the hourglassSum function below.
    static int hourglassSum(final int[][] arr) {
        final int maxI =  arr.length;
        final int maxJ = arr[0].length;

        boolean hasValue = false;
        int maxSum = 0;

        for (int i = 0; i + 2 < maxI; i++) {
            for (int j = 0; j + 2 < maxJ; j++) {
                int sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
                sum += arr[i + 1][j + 1];
                sum += arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];

                if (!hasValue) {
                    maxSum = sum;
                    hasValue = true;
                } else if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }

    public static void main(final String... args) {
        final int[][] arr = {
                {-9, -9, -9, 1, 1, 1},
                {0, -9, 0, 4, 3, 2},
                {-9, -9, -9, 1, 2, 3},
                {0, 0, 8, 6, 6, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };

        //Validate negative result

        System.out.println(hourglassSum(arr));
    }
}
