package com.java8.streams;

import java.util.Arrays;
import java.util.Collection;
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
        // Perform action on each element as it is consumed
        // Example-1
        System.out.println("\npeek()");
        Stream.of(1,2,3,4,5)
                .peek(n -> System.out.println("Before map: " + n))
                .map(n -> n * 2)
                .forEach(System.out::println);

        // Example-2
        System.out.println("\nexample2 peek");
        Stream.iterate(1, x -> x + 1).skip(10).limit(50).peek(System.out::println).count();
        // this will print numbers from 11 to 60 because 1 to 10 is skipped
        // count will be ignored because we haven't consumed it in long and I have used it because we have to
        // use terminal ops to end stream otherwise peek will be ignored

        // 8. flatMap
        // Handle streams of collections, lists, or arrays where each element is itself a collection
        // Flatten nested structures (e.g., lists within lists) so that they can be processed as a single sequence of elements
        // Transform and flatten elements at the same time.
        System.out.println("\nflatMap()");
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("Apple", "Banana"),
                Arrays.asList("Guava", "Dates"),
                Arrays.asList("Melon", "Watermelon")
        );
        System.out.println(nestedList.get(1).get(1)); // Dates
        //nestedList.stream().flatMap(list -> list.stream()).map(String::toUpperCase).toList();
        // Using method reference
        System.out.println(nestedList.stream().flatMap(Collection::stream).map(String::toUpperCase).toList());

        System.out.println();
        List<String> sentences = Arrays.asList(
                "Hello, World",
                "I am Vishant Niboray",
                "Java Developer Intern"
        );
//        sentences.stream().flatMap(x -> x.stream()) // we cannot directly convert string to stream so to do so
//        sentences.stream().flatMap(x -> x.split(" ")); // x.split() will return array but we want stream
        System.out.println(sentences.stream()
                .flatMap(x -> Arrays.stream(x.split(" ")))
                .map(String::toUpperCase)
                .toList());


        System.out.println("\nPractice Questions");
        // Q. print first 3 even numbers
        System.out.println("\nPrint first 3 even numbers");
        List<Integer> numList = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
        numList.stream().filter(n -> n % 2 == 0).limit(3).forEach(System.out::println);
    }
}
