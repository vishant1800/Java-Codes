package com.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LazyEvaluation {
    public static void main(String[] args) {
        // Example 1
        List<Integer> list = Arrays.asList(2,5,1,7,4,9,6,8);
        Stream<Integer> stream = list.stream()
                .filter(n -> {
                    System.out.println("Checking: " + n);
                    return n % 2 == 0;
                });

        System.out.println("Before Stream");
        long evenCount = stream.count();
        System.out.println("After Stream\n");

        // Example 2
        list.stream()
                .filter(n -> {
                    System.out.println("Checking Num: " + n);
                    return n > 3;
                })
                .findFirst()
                .ifPresent(System.out::println);



    }
}
