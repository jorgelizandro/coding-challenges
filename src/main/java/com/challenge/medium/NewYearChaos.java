package com.challenge.medium;

import java.util.Arrays;

public class NewYearChaos {
    private static final String TOO_CHAOTIC = "Too chaotic";
    static void minimumBribes(final int[] line) {
        final int[] expectedLine = new int[line.length];
        Arrays.setAll(expectedLine, index -> index + 1);

        System.out.println(Arrays.toString(line));
        int bribeCount = 0;
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i +1 < line.length; i++) {
                if (line[i] != expectedLine[i] &&
                        (line[i + 1] == expectedLine[i] || line[i] == expectedLine[i + 1]) &&
                        line[i] > line[i + 1]) {
                    final int tmpVal = line[i + 1];
                    line[i + 1] = line[i];
                    line[i] = tmpVal;

                    bribeCount++;
                }
            }
            System.out.println(Arrays.toString(line));
        }

        if (Arrays.equals(line, expectedLine)) {
            System.out.println(bribeCount);
        } else {
            System.out.println(TOO_CHAOTIC);
        }
    }

    public static void main(final String... args) {
        minimumBribes(new int[]{1, 2, 5, 3, 7, 8, 6, 4});
/*
        minimumBribes(new int[]{1, 2, 5, 3, 4, 7, 8, 6});
        minimumBribes(new int[]{1, 2, 3, 7, 5, 8, 6, 4});
        minimumBribes(new int[]{2, 1, 5, 3, 4});
        minimumBribes(new int[]{2, 5, 1, 3, 4});
        minimumBribes(new int[]{1, 2, 5, 3, 6, 4});*/
    }
}
