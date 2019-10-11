package com.challenge.easy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepeatedString {

    private static final Pattern PATTERN = Pattern.compile("a");

    public static long repeatedString(String s, long n) {
        long fullRepetitionCount = n / s.length();
        long partialRepetitionCount = n % s.length();
        String subInfiniteString = s.substring(0, (int) partialRepetitionCount);

        return fullRepetitionCount * getMatchesCount(s) + getMatchesCount(subInfiniteString);
    }

    private static long getMatchesCount(String s) {
        Matcher matcher = PATTERN.matcher(s);

        long matcherCount = 0L;
        while (matcher.find()) {
            matcherCount++;
        }

        return matcherCount;
    }


    public static void main(final String... args) {
        System.out.println("Hello!");
        System.out.println(repeatedString("aba", 10L)); //7
        System.out.println(repeatedString("a", 1000000000000L)); //1000000000000
    }
}
