package com.challenge.easy;

import java.util.Arrays;

public class GradingStudents {

    /*
     * Complete the gradingStudents function below.
     */
    static int[] gradingStudents(final int[] grades) {
        /*
         * Write your code here.
         */
        for (int i = 0; i < grades.length; i++) {
            final int grade = grades[i];
            if (grade >= 38) {
                final int nextGrade = (grade + 5)/5*5;
                if (nextGrade - grade <= 2) {
                    grades[i] = nextGrade;
                }
            }
        }

        return grades;
    }

    public static void main(final String... args) {
        final int[] grades = {73, 67, 38, 33};

        System.out.println(Arrays.toString(gradingStudents(grades)));
    }
}
