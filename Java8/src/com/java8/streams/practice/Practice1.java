package com.java8.streams.practice;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Practice1 {
    public static void main(String[] args) {
//        1. Given a list of integers,
//              - create a list of all even numbers
//              - create a list of squares of all odd numbers.
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        System.out.println("Even Numbers List");
        System.out.println(list.stream().filter(x -> x % 2 == 0).toList());

//        2. Given a list with duplicates,
//        - create a sorted list in descending order with unique elements only
        List<Integer> list1 = Arrays.asList(2,2,6,5,1,5,10,10);
        System.out.println("\nList in descending order with no duplicates");
        System.out.println(list1.stream().distinct().sorted((a, b) -> b - a).toList());

//        3. From a list of integers, find the top 3 largest numbers
        System.out.println("\ntop 3 largest numbers in a list");
        System.out.println(list.stream().sorted((a, b) -> b - a).limit(3).toList());

//        4. From a list of integers, find the first number greater than 50, or return -1 if none exists.
        System.out.println("\nfirst number greater than 50 or return -1 if none exists");
        List<Integer> list3 = Arrays.asList(10,24,15,49,50,59,60,70);
        System.out.println(list3.stream().filter(x -> x > 50).findFirst().get());

//        5. Given a list of integers, determine:
//
//        if any number is negative
//
//        if all numbers are even
//
//        if no number is zero
        System.out.println("\nNegative, All Even and No Zero");
        List<Integer> list4 = Arrays.asList(2,4,56,-1,3,0);
        System.out.println(list4.stream().anyMatch(x -> x < 0));
        System.out.println(list4.stream().allMatch(x -> x % 2 == 0));
        System.out.println(list4.stream().noneMatch(x -> x == 0));

    }
}
