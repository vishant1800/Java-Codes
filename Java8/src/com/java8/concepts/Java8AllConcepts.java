package com.java8.concepts;

import com.sun.tools.jconsole.JConsoleContext;

import java.sql.Array;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.*;

public class Java8AllConcepts {
    public static void main(String[] args) {
        // Lambda expression
        System.out.println("Lambda expression");
        MathOperation sum = (a, b) -> a + b;
        MathOperation multiply = (a, b) -> a * b;
        int sumRes = sum.operate(5, 3);
        int mulRes = multiply.operate(4, 7);
        System.out.println(sumRes);
        System.out.println(mulRes);

        // Predicate
        System.out.println("\nPredicate");
        Predicate<Integer> predicate = x -> x % 2 == 0;
        System.out.println(predicate.test(4));

        Predicate<String> subString = str -> str.contains("isha");
        System.out.println(subString.test("Vishant"));

        Predicate<Integer> numCheck = num -> num.toString().startsWith("9");
        Predicate<Integer> numCheck2 = num -> num.toString().endsWith("6");
        System.out.println(numCheck.and(numCheck2).test(966875214));

        // Function
        System.out.println("\nFunction");
        Function<Integer, Integer> square = x -> x * x;
        Function<Integer, Integer> cube = x -> x * x * x;

        // square -> cube
        System.out.println(square.andThen(cube).apply(2)); // 2*2 ->4 now x is 4 so 4 * 4 * 4 = 64
        // cube -> square
        System.out.println(cube.andThen(square).apply(3)); // same
        // cube -> square
        // these two are same because in both cube will be called first and then square
        System.out.println(square.compose(cube).apply(3)); // same

        // identity is a static method
        // it just returns, what is given to it
        Function<Integer, Integer> res = Function.identity();
        Integer res2 = res.apply(5);
        System.out.println(res2); // res2 will be 5

        // Consumer
        // Consumer accepts input but returns nothing(void)
        // Used when you want to perform an action on an input
        System.out.println("\nConsumer");
        Consumer<Integer> consumer = x -> System.out.println(x);
        consumer.accept(100);
        Consumer<Integer> sq = sqr -> System.out.println(sqr * sqr);
        sq.accept(5);

        // andThen() default method
        consumer.andThen(sq).accept(12);

        System.out.println("Consumer with list");
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Consumer<List<Integer>> printList = li -> {
                for (int i : list) {
                    System.out.println(i);
                }

        };

        // list.forEach(n -> System.out.println(n)); // this can also be done because forEach internally
        // uses Consumer
        printList.accept(list);


        // Supplier
        // A Supplier is a functional interface that does NOT take any input but returns an output.
        // Purpose:
        // Generate or supply values
        // Used when no input is needed, but a result must be returned
        // Used in factories, random value generators, IDs, timestamps etc.
        System.out.println("\nSupplier");

        // get() abstract method
        Supplier<String> greet = () -> "Hello, Vishant";
        System.out.println(greet.get());

        Supplier<Double> random = () ->Math.random() * 10;
        System.out.println(random.get());

        // COMBINED EXAMPLE
        System.out.println("\nCombined example");
        Predicate<Integer> predicate1 = n -> n % 2 == 0;
        Function<Integer, Integer> function = n -> n * n;
        Consumer<Integer> consumer1 = n -> System.out.println(n);
        Supplier<Integer> supplier = () -> 80;

        if(predicate1.test(supplier.get())) { // it will check if 80 is even, then
            consumer1.accept(function.apply(supplier.get())); // consumer will accept 6400
        }


        // BiPredicate, BiFunction, BiConsumer
        // takes two inputs
        System.out.println("\nBiPredicate, BiFunction, BiConsumer");
        // takes two inputs and return boolean
        // checks both the string starts with same letter
        BiPredicate<String, String> startWithSameLetter = (st1, st2) ->
                st1.toLowerCase().startsWith("v") == st2.toLowerCase().startsWith("v");

        // merge two strings
        BiFunction<String, String, String> mergeString = (st1, st2) -> st1 + st2;

        // print both strings
        BiConsumer<String, String> printStr = (st1, st2) -> System.out.println(st1 + "\n" + st2);
        System.out.println(startWithSameLetter.test("Vishant", "Vinay"));
        System.out.println(mergeString.apply("Vishant", "Vinay"));
        printStr.accept("Hello", "Vishant");


        // Method reference
        // Method Reference is a shortcut for calling an existing method without writing a lambda expression
        System.out.println("\nMethod and Constructor Reference");
        // 1. Convert list of strings to uppercase using method reference (String::toUpperCase)
        // Reference to an Instance Method of a Class
        Function<String, String> strUpper = String::toUpperCase; // ClassName::instanceMethod
        System.out.println(strUpper.apply("netlink"));

        // 2. Print all elements of list using method reference (System.out::println)
        // Reference to a static method
        List<Integer> sList = Arrays.asList(1,2,3,4,5,6);
        // without lambda
        sList.forEach(System.out::println); // with lambda - sList.forEach(x -> System.out.println(x));

//        3. Create a Supplier that returns current time using method reference (LocalTime::now)
        // Reference to a static method
        Supplier<LocalTime> currTime = LocalTime::now; // ClassName::staticMethod
        System.out.println(currTime.get());

//        4. Use Predicate + Method reference to check if a string is empty (String::isEmpty)
        // Reference to an instance method of a class
        Predicate<String> checkIsEmpty = String :: isEmpty; // ClassName::instanceMethod
        System.out.println(checkIsEmpty.test(""));

//        5. Use Constructor Reference to create an object of your own class
        // Constructor Reference
        Supplier<Person> obj = Person::new;
        obj.get();

        // Reference to an instance method (Object Method)
        String str = "supreme";
        Supplier<Integer> s = str::length;
        System.out.println(s.get());
        System.out.println();

        // UnaryOperator and BinaryOperator
        System.out.println("\nUnaryOperator and BinaryOperator");
        // Both extends Function Interface
        // UnaryOperator - Represents an operation that accepts a single operand and
        // returns a result of the same type as the operand.
        UnaryOperator<Integer> a = x -> x * 2;

        // BinaryOperator - Represents an operation that accepts two operands of the same type
        // and returns a result of that same type.
        BinaryOperator<Integer> b = (x, y) -> x * y;
        System.out.println(b.apply(2,4));
        System.out.println(a.apply(1));

        int []arr = {1,2,3,4,5};

    }
}

class Person {
    String name;
    int age;

    Person() {
        System.out.println("Person constructor called");
    }
}

@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}
