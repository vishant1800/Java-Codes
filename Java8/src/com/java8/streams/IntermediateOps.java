package com.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOps {
    public static void main(String[] args) {
//        Intermediate operations are:
//
//        - lazy (meaning they don’t execute until terminal operation is invoked)
//        - return a new stream
//        - used to build a pipeline
//        - Execute only when the terminal operation comes
//        - doesn't change the actual data

        // 1. filter - Used to keep only elements that match a condition.
        System.out.println("filter()");
        List<String> pList = Arrays.asList("Aman", "Rahul", "Ramesh", "Ritika", "Rahul");
        Stream<String> stream1 = pList.stream().filter(xtr -> xtr.startsWith("R"));
        stream1.forEach(System.out::println);

        // 2. map() - Used to transform elements.
        System.out.println("\nmap()");
        Stream<String> strUpper = pList.stream().map(String::toUpperCase);
        strUpper.forEach(System.out::println);

        // 3. sorted()
        // Without comparator - ascending order (a,b) -> a - b
        System.out.println("\nSorting without comparator");
        Stream<String> ascSorted = pList.stream().sorted();
        ascSorted.forEach(System.out::println);

        // With comparator
        System.out.println("\nSorting using comparator based on length");
        Stream<String> descSorted = pList.stream().sorted((a,b) -> b.length() - a.length());
        descSorted.forEach(System.out::println);

        // 4. distinct() - remove duplicates
        System.out.println("\ndistinct()");
        pList.stream().distinct().forEach(System.out::println);
        System.out.println("\ndistinct that starts with R");
        pList.stream()
                .filter(x->x.startsWith("R"))
                .distinct()
                .forEach(System.out::println);

        // 5. limit
        System.out.println("\nlimit() 1st way");
        Stream.of(10, 20, 30, 40).limit(2).forEach(System.out::println);
        System.out.println("\n2nd way");
        System.out.println(Stream.iterate(1, x -> x + 1).limit(10).count());

        // 6. skip()
        System.out.println("\nskip()");
        pList.stream().skip(2).forEach(System.out::println);

        // 7. peek - for debugging
        // Used to see values in between operations.
        System.out.println("\npeek()");
        Stream.of(1,2,3,4,5)
                .peek(n -> System.out.println("Before map: " + n))
                .map(n -> n * 2)
                .forEach(System.out::println);

        // Q. print first 3 even numbers
        System.out.println("\nPrint first 3 even numbers");
        List<Integer> numList = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
        numList.stream().filter(n -> n % 2 == 0).limit(3).forEach(System.out::println);
    }
}
