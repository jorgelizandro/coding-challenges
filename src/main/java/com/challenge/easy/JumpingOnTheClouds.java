package com.challenge.easy;

public class JumpingOnTheClouds {
    private static final int THUNDERHEAD = 1;
    private JumpingOnTheClouds() {
    }

    static int jumpingOnClouds(int[] c) {
        if (c == null || c[0] == THUNDERHEAD) {
            return -1;
        }

        int cumulusCount = 0;
        int jumpCount = 0;
        for (int cloudType: c) {
            if (cloudType == THUNDERHEAD) {
                if (jumpCount > 0) {
                    jumpCount++;
                }
                jumpCount += Math.round((float)cumulusCount / 2);
                cumulusCount = 0;
            } else {
                cumulusCount++;
            }
        }

        return jumpCount + Math.round((float)cumulusCount / 2);
    }
    public static void main(String... args) {
        System.out.println(jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 0})); //4
        System.out.println(jumpingOnClouds(new int[]{0, 0, 0, 1, 0, 0}));; //3
        System.out.println(jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 0, 0, 1, 0, 0})); //6
        //System.out.println(jumpingOnClouds(new int[]{0, 1, 0, 1, 0, 1 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 1 0 1 0 0 1 0 0 0 1 0 1 0 0 0 1 0 1 0 1 0 1 0 0 0 1 0 0 0 0 0 1 0 1 0 1 0 0 1 0 1 0 1 0 0 1 0 0 0 0 1 0 0 1 0 0 0 1 0 0 1 0 1, 0}));  //46
    }
}
