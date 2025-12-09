package com.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ParallelStreamDemo2 {
    public static void main(String[] args) {
        // In this case task is dependent because here we are finding Cumulative Sum
        // and each number is dependent on its previous numbers
        List<Integer> list = Arrays.asList(1,2,3,4,5);

//        int sum = 0;
//        List<Integer> result = list.parallelStream()
//                .map(x -> {
//                    int i = x + sum; // sum is giving error because sum should be final and if you make it final
//                    // then you cannot change it
//                    sum = i;
//                    return i;
//                }).toList();
//        this will give error because inside Parallel Stream we can use lambda expression and sum is also not final
//        then it will cause data inconsistency and to solve it we will use AtomicInteger to achieve "thread safety"


        AtomicInteger sum = new AtomicInteger(0);
        List<Integer> result = list.parallelStream()
                .map(sum::addAndGet).toList(); // addAndGet is method of AtomicInteger
        // and still we won't get expected output i.e. [1,3,6,10,15] because parallel stream only work if
        // task is independent
        // this will work fine if we will use stream

        System.out.println("Expected output [1,3,6,10,15]");
        System.out.println("Parallel Stream output: " + result);



    }
}
