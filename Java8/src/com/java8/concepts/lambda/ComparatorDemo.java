package com.java8.concepts.lambda;

import java.util.Comparator;

public class ComparatorDemo implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b){
            return b - a;  // sorts in descending order
    }
}
