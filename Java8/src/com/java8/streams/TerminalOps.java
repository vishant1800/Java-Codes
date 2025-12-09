package com.java8.streams;

import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TerminalOps {
    public static void main(String[] args) {
//        Terminal Operations
//        Terminal operations end the stream pipeline and produce a final result (output, collection, value, etc.).
//        Once a terminal operation is called → the stream is consumed and cannot be reused.

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);

        // 1. forEach
        System.out.println("forEach()");
        list.stream().forEach(System.out::println);

        // 2. collect - Used to convert stream → list, set, map, string, etc.
        System.out.println("\ncollect()");
        // Collect to List
        System.out.println("Collect to List");
        // List<Integer> list1 = list.stream().collect(Collectors.toList()); // used in previous versions of java
        // OR
        List<Integer> list1 = list.stream().toList();
        list1.forEach(System.out::println);

        // Collect to Set
        System.out.println("Collect to Set");
        Set<Integer> set = list.stream().collect(Collectors.toSet());
        set.forEach(System.out::println);

        // Collect to String (Joining)
//        String str = list.stream().collect(Collectors.joining(", ")); // this works only for string or char
        // so first we have to convert integer list to string
        System.out.println("Collect to String");
        String str = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(str);

        // 3. count()
        System.out.println("\ncount()");
        long total = list.stream().filter(x -> x > 5).count();
        System.out.println(total);

        // 4. reduce() : Combines elements to produce a single result
        System.out.println("\nreduce()");
        //basic form
//        T result = stream.reduce(initialValue, (a, b) -> operation); // it will also work without initialValue

        // (e.g., sum, product, max, min, concatenate strings)
//        Optional<Integer> sum = list.stream().reduce((a, b) -> a+b);
        // OR
        Optional<Integer> sum = list.stream().reduce(Integer::sum);
        System.out.println(sum.get());

        Integer max = list.stream().reduce(Integer.MIN_VALUE, (a,b) -> Math.max(a,b));
        System.out.println(max);
        // OR
        Integer max2 = list.stream().reduce(Integer.MIN_VALUE, Math::max);
        System.out.println(max2);

        int sum1 = list.stream().reduce(0, Integer::sum); // initialValue is 0, if it is 2 then sum will be 38 i.e. 36 + 2
        System.out.println(sum1);

        // 5. allMatch(), anyMatch() and noneMatch()
        System.out.println("\nMatch()");
        // anyMatch() - True if ANY element matches condition
        boolean res = list.stream().anyMatch(x -> x % 2 == 0);
        System.out.println("anyMatch() - " + res);

        // allMatch() - True if ALL elements match condition
        boolean res1 = list.stream().allMatch(x -> x > 0);
        System.out.println("allMatch() - " + res1);

        // noneMatch() - True if NO element matches condition
        boolean res2 = list.stream().noneMatch(x -> x < 0);
        System.out.println("noneMatch() - " + res2);

        // 6. findFirst() - Returns first element in stream
        // and findAny() - Return any element from the
        System.out.println("\nfindFirst() and findAny()");
        System.out.println(list.stream().findFirst().get()); // get() is used because findFirst is an Optional
        System.out.println(list.stream().findAny().get());

        // 7. toArray() = stream -> array
        System.out.println("\ntoArray()");
        Object[] arr = Stream.of(1,2,3,4,5).toArray();
        for(Object x : arr) {
            System.out.println(x);
        }

        // 8. max() and min()
        System.out.println("\nmax() and min()");
        System.out.println("Using Comparator");
        Optional<Integer> mx = list.stream().max(Comparator.naturalOrder());
        System.out.println(mx.get());
        System.out.println(list.stream().min(Comparator.naturalOrder()).get());

        // max() and min() using lambda expression for Comparator means overriding compare()
        System.out.println(list.stream().max((o1, o2) -> o1 - o2).get()); // used get() because max returns Optional
        // it doesn't matter if i use max or min in lambda expression because here i have done o2 - o1
        // which will return minimum and o1 - o2 returns maximum
        System.out.println(list.stream().max((o1, o2) -> o2 - o1).get());

        // max() and min() using Comparable
        System.out.println("Using Comparable");
        Optional<Integer> max1 = list.stream().max(Comparable::compareTo);
        Optional<Integer> min1 = list.stream().min(Comparable::compareTo);
        System.out.println(max1.get());
        System.out.println(min1.get());

        System.out.println("Using Integer method");
        Optional<Integer> mx2 = list.stream().max(Integer::compareTo);
        Optional<Integer> min2 = list.stream().min(Integer::compareTo);
        System.out.println(mx2.get());
        System.out.println(min2.get());

        // 9. forEachOrdered() - it is used to print elements of parallel stream in ORDER
        System.out.println("\nforEachOrdered()");
        List<Integer> newList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println("Parallel Stream using forEach()");
        newList.parallelStream().forEach(System.out::println); // no order will be followed
        System.out.println("Parallel Stream using forEachOrdered()");
        newList.parallelStream().forEachOrdered(System.out::println);

        System.out.println("\n Practice Questions");
        // Example: Filtering and Collecting names whose length is greater than 3
        System.out.println("Q. Names whose length is greater than 3");
        List<String> nameList = Arrays.asList("Ayush", "Eve", "PK", "Ronin", "Anish");
        System.out.println(nameList.stream().filter(x -> x.length() > 3).toList());

        System.out.println("\nQ. Squaring and sorting numbers");
        System.out.println(list.stream().map(x -> x * x).sorted().toList());

        System.out.println("\nQ. Summing values");
        System.out.println(list.stream().reduce(Integer::sum).get());

        System.out.println("\nQ. Convert list {“Aman”, “Rohan”, “Sita”} into a single string like Aman-Rohan-Sita");
        System.out.println(Stream.of("Aman", "Rohan", "Sita").map(x->x).collect(Collectors.joining("-")));
        //map(x->x) is doing nothing, just added to follow the convention
        
        // without streams
        System.out.println(String.join("-", "Aman", "Rohan", "Sita"));


        System.out.println("\nQ. Counting occurences of a character");
        String greet = "Hello World";
//        char[] charArray = greet.toCharArray();
//        Arrays.stream(charArray) // this will give error this is not how we can convert character array to stream
        System.out.println(greet.chars().filter(x -> x == 'l').count());
        // chars() return value of type IntStream because every character has ASCII value

        System.out.println("\nUsing the streams again");
        Stream<String> stream = nameList.stream();
        stream.forEach(System.out::println);
//        Stream<String> stream1 = stream.map(String::toUpperCase); // this will throw error
        // because stream is already consumed. Streams cannot be reused after the terminal
        // operation has been called like in this case forEach is called and after that you
        // cannot reuse the stream

    }
}
