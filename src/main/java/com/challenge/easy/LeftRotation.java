package com.challenge.easy;

import java.util.Arrays;

public class LeftRotation {

    static int[] rotLeft(int[] a, int d) {
        if (d == a.length) {
            return a;
        }

        final int[] aRotated = new int[a.length];
        System.arraycopy(a, d, aRotated, 0, a.length - d);
        System.arraycopy(a, 0, aRotated, a.length - d, d);

        return aRotated;
    }

    public static void main(final String... args) {
        final int[] arr = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(rotLeft(arr, 1)));
        System.out.println(Arrays.toString(rotLeft(arr, 2)));
        System.out.println(Arrays.toString(rotLeft(arr, 3)));
        System.out.println(Arrays.toString(rotLeft(arr, 4)));
        System.out.println(Arrays.toString(rotLeft(arr, 5)));
    }
}
