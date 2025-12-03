package com.java8.concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
//        Predicate<Integer> salaryCheck = x -> x > 100000;
//        System.out.println(salaryCheck.test(10000000));

        Predicate<Integer> isEven = n -> n % 2 == 0;
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        System.out.println("Even numbers");
        for(Integer i : list) {
            if(isEven.test(i)){
                System.out.println(i);
            }
        }

        Predicate<Integer> checkEven = num -> num % 2 == 0;
        System.out.println(checkEven.test(3));
        Predicate<String> isCorrect = str -> str.contains("Java");
        System.out.println(isCorrect.test("Javascript"));


    }
}
