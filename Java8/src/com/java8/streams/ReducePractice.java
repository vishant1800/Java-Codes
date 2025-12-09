package com.java8.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReducePractice {
    public static void main(String[] args) {
//        Q1: Use reduce to count length of all strings in list.
//        Q2: Use reduce to get the sum of squares of numbers.
//        Q3: Use reduce to find the smallest string (lexicographically).
//        Q4: Use reduce to check if ALL numbers are positive (return boolean).

        // 1
        List<String> words = Arrays.asList("computer", "earbuds", "cabin");
        System.out.println(words.stream()
                .map(String::length)
                .reduce((a, b) -> a + b).get()); // or reduce(Integer::sum)

        // 2
        List<Integer> nums = Arrays.asList(1,2,3,2,5,9,-1);
        Optional<Integer> sum = nums.stream()
                .map(x -> x * x)
                .reduce(Integer::sum);
        System.out.println(sum.get());

        // 3
        System.out.println(words.stream()
                .reduce((s1, s2) -> s1.compareTo(s2) <= 0 ? s1 : s2)//string is compared using
                // compareTo
                .orElse(""));
        // OR
        System.out.println(words.stream()
                .min(String::compareTo)
                .orElse(""));

        // 4
        List<Integer> nList = Arrays.asList(1,-2,-1);
//        Optional<Integer> reduce = nList.stream()
//                .map(x -> x > 0 ? 1 : 0)
//                .reduce((a, b) -> (a > 0 && b > 0) ? 1 : 0);

        // Correct and simplified version
        // orElse is used to handle the exception
        boolean reduce = nList.stream()
                .map(x -> x > 0)
                .reduce((a, b) -> a && b) // this is actually
        // if (a && b)
        // return true;
        // else return false;
                .orElse(true);

        System.out.println(reduce);
    }
}
