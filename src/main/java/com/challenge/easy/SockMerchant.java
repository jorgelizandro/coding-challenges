package com.challenge.easy;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SockMerchant {
    private SockMerchant() {

    }

    static int sockMerchant(int n, int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        Map<Integer, Long> countMap =
                Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingByConcurrent(Function.identity(), Collectors.counting()));

        Long pairTotal = countMap.values().stream()
                .map(a -> (Long)(a/2))
                .reduce(0L, Long::sum);

        return pairTotal.intValue();
    }

    public static void main(final String... args) {
        System.out.println("The socks pair count is:");
        System.out.println(sockMerchant(7, new int[]{1, 2, 1, 2, 1, 3, 2}));    //2
        System.out.println(sockMerchant(9, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20}));     //3
    }
}
