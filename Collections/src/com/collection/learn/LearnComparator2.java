package com.collection.learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LearnComparator2 {
    public static void main(String[] args) {

        // Comparator compare() method can be used to define custom sorting
//        Comparator<String> com = new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                if(o1.length() > o2.length()){
//                    return 1;
//                } else {
//                    return -1;
//                }
//            }
//        };
        // OR
        // Comparator using lambda expression
        Comparator<String> com = ( o1, o2) -> o1.length() > o2.length() ? 1 :-1;

        List<String> list = new ArrayList<>();

        list.add("Phone");
        list.add("Earphones");
        list.add("Laptop");
        list.add("Bag");

        Collections.sort(list, com);

        System.out.println(list);
    }
}
