package com.java8.concepts;

import java.util.function.Predicate;

public class PredicateDemo2 {
    public static void main(String[] args) {
        Predicate<String> nameInitial = name -> name.toLowerCase().charAt(0) == 'v';
        Predicate<String> nameEnds = name -> name.toLowerCase().endsWith("t");
        boolean res = nameInitial.test("Nishant");
        boolean res2 = nameEnds.test("Akshat");
        System.out.println(res);
        System.out.println(res2);
    }
}
