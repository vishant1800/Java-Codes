package com.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamDemo1 {
    public static void main(String[] args) {
        // Parallel Stream
        // A type of stream that enables parallel processing of elements
        // Allowing multiple threads to process parts of the stream simultaneously
        // This can significantly improve performance for large data sets
        // workload is distributed across multiple threads
        // Parallel streams are most effective for CPU-intensive or large datasets where tasks are independent
        // like in this case no number is dependent on other in the list, a single number is needed to find
        // the factorial so here task is independent
        // They may add overhead for simple tasks or small datasets

        System.out.println("This thread is used behind Parallel Stream");
        List<Integer> tryList = Arrays.asList(1,2,3,4,5);
        tryList.parallelStream()
                .forEach(n -> System.out.println(n + " " + Thread.currentThread().getName()));
        System.out.println();

        System.out.println("Sequential Stream vs Parallel Stream");
        long startTime = System.currentTimeMillis();
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();
        List<Integer> factorialList = list.stream().map(ParallelStreamDemo1::factorial).toList();
        // parallel() method can be used to convert stream into parallel stream
//        List<Integer> factorialList = list.stream().map(ParallelStreamDemo1::factorial).parallel().toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken by sequential stream: " + (endTime - startTime) + "ms"); // around 190 to 200 ms

        startTime = System.currentTimeMillis();
        List<Integer> factorialList1 = list.parallelStream().map(ParallelStreamDemo1::factorial).toList();
        // sequential() method can be used to convert parallel stream to sequential stream
//        factorialList1 = list.parallelStream().map(ParallelStreamDemo1::factorial).sequential().toList();
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by parallel stream: " + (endTime - startTime) + "ms"); // around 40 to 60 ms
    }

    public static int factorial(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = i * fact;
        }
        return fact;
    }
}
