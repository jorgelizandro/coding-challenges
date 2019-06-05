package com.challenge.easy;

public class TimeConversion {
    /*
     * Complete the timeConversion function below.
     */

    private static final String AM = "AM";

    static String timeConversion(final String s) {
        /*
         * Write your code here.
         */
        final String[] parts = s.split(":");
        final String seconds = parts[2].substring(0, 2);
        final String timePeriod = parts[2].substring(2, 4);
        final int hours12 = Integer.parseInt(parts[0]);
        final boolean am = timePeriod.equalsIgnoreCase(AM);
        int hours24;

        if (hours12 < 12) {
            hours24 = am ? hours12 : hours12 + 12;
        } else {
            hours24 = am ? 0 : hours12;
        }

        return String.format("%02d", hours24) + ":" + parts[1] + ":" + seconds;
    }


    public static void main(final String... args) {
        System.out.println(timeConversion("07:05:45PM"));
        System.out.println(timeConversion("12:05:45AM"));
        System.out.println(timeConversion("12:05:45PM"));
    }
}
