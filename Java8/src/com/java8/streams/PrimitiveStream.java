package com.java8.streams;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitiveStream {
    public static void main(String[] args) {
        // Creating IntStream from Array
        int[] arr = {1,2,3,4,5,6};
        IntStream arrStream = Arrays.stream(arr);

        // Creating IntStream using range

        System.out.println(IntStream.range(1, 5)// it will create stream which has values 1,2,3,4
                // so 1 is inclusive and 5 is exclusive
                .boxed() // boxed() converts primitive stream to object stream
                // like IntStream to Integer Stream because list,map,set uses Wrapper classes
                .collect(Collectors.toList()));

        System.out.println(IntStream.rangeClosed(1,7).map(x->x*x).boxed().toList());

        System.out.println(IntStream.rangeClosed(1,5)
                .boxed()
                .collect(Collectors.toList()));

        // Using mapToInt
        List<Integer> nums = Arrays.asList(1,2,3,4);
        IntStream intStream = nums.stream().mapToInt(n -> n); // Object Stream to IntStream

        // Similarly, we can also create LongStream and DoubleStream
        LongStream ls = LongStream.range(1, 100);
        DoubleStream ds = DoubleStream.of(1.2, 2.5, 4.5, 4.4); // range is not allowed with DoubleStream

        // Another way of creating IntStream similar to Stream
        IntStream.of(1,2,3,4,5);

        // Random Class
        DoubleStream randomDS = new Random().doubles(7); // stream of 7 random doubles will be created
//        System.out.println(randomDS); // this will return class so we have to box it and convert to list
        System.out.println(randomDS.boxed().toList());

        // Similarly for int
        IntStream randomIS = new Random().ints(3);
        System.out.println(randomIS.boxed().toList());

        // Some functions similar to streams
        int sum = IntStream.range(1,7).sum();

        double avg = IntStream.range(1,6).average() // average returns OptionalDouble so to convert it to
                // double we can use getAsDouble
                .getAsDouble();

        int max = IntStream.range(1,4).max().getAsInt();
        int min = IntStream.range(1,6).min().getAsInt();

        // IntSummaryStatistics
        IntSummaryStatistics stats = IntStream.of(1,2,9,3,4,5,5)
                .summaryStatistics();

        System.out.println(stats.getAverage());
        System.out.println(stats.getMax());
        System.out.println(stats.getCount());
        System.out.println(stats.getMin());
        System.out.println(stats.getSum());

    }
}
