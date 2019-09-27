package com.challenge.easy;

public class CountingValleys {
    private CountingValleys() {

    }

    static int countingValleys(int n, String s) {
        if (s == null || s.isEmpty()) {
            return -1;
        }

        char[] steps = s.toCharArray();

        int level = 0;
        int valleyCount = 0;
        boolean startedValley = false;
        for (char step: steps) {
            switch (step) {
                case 'U':
                    level++;
                    break;
                case 'D':
                    level--;
                    break;
                default:
                    return -1;
            }

            if (level < 0) {
                startedValley = true;
            } else if (level == 0 && startedValley) {
                valleyCount++;
                startedValley = false;
            }
        }

        return valleyCount;
    }


    public static void main(final String... args) {
        System.out.println("Valleys count:");
        System.out.println(countingValleys(8, "UDDDUDUU"));
        System.out.println(countingValleys(10, "UDUUUDUDDD"));
    }
}
