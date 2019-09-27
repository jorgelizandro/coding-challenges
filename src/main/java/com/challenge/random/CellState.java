package com.challenge.random;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CellState {

    public List<Integer> cellCompete(int[] states, int days) {
        if (days <= 0) {
            return Arrays.stream(states)
                    .boxed()
                    .collect(Collectors.toList());
        }

        int[] newStates = new int[states.length];
        for(int i = 0; i<states.length; i++) {
            int left = i == 0 ? 0 : states[i-1];
            int right = i == states.length - 1 ? 0 : states[i+1];
            int current = states[i];

            boolean flipState = left == right;

            if (flipState) {
                newStates[i] = current == 1 ? 0 : 1;
            } else {
                newStates[i] = states[i];
            }
        }

        return cellCompete(newStates, days - 1);
    }

    public static void main(final String... args) {
        CellState cellState = new CellState();

        System.out.println(cellState.cellCompete(new int[]{1, 0, 1, 1, 0, 0}, 3));
        //The expected result is: {0, 0, 1, 1, 1, 0}
    }
}
