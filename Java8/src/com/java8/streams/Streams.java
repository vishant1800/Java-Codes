package com.java8.streams;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        /// What is stream ?
        // a sequence of elements supporting functional and declarative programing

        /// How to Use Streams ?
        // Source, intermediate operations & terminal operation

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,8,7,9);
        // It will count the number of even numbers in the list
        System.out.println(numbers.stream().filter(x -> x % 2 == 0).count());

        /// Ways to create streams
        // 1. From collections
        List<Integer> aList = Arrays.asList(1,2,3,4,4);
        Stream<Integer> stream = aList.stream();

        // 2. From Arrays
        String[] arr = {"a", "b", "c"};
        Stream<String> stream1 = Arrays.stream(arr);

        // 3. Using Stream.of
        Stream<String> stream3 = Stream.of("a", "b", "c");

        // 4. Infinite Streams
        // 1st way
        Stream<Integer> generate = Stream.generate(() -> 1); // infinite stream of 1
        Stream<Integer> generate1 = Stream.generate(() -> 1).limit(100); // finite stream of size 100
        Stream<Double> random = Stream.generate(Math::random);
        random.limit(5).forEach(System.out::println);
        // 2nd way
        // stream of size 100
        // seed means starting value
        // then x + 1 = 1 + 1 = 2, 2+1 =3 +1=4 and it will go on it 100
        List<Integer> collect1 = Stream.iterate(0, x -> x + 2).limit(50)
                .collect(Collectors.toList());
        System.out.println(collect1);

        // 5. Using Stream Builder
        Stream.Builder<String> builder = Stream.builder();
        builder.add("A");
        builder.add("B");
        builder.add("C");

        Stream<String> s = builder.build();
        s.forEach(System.out::println);
    }

}
