package com.collection.learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LearnComparator {
    public static void main(String[] args) {

        Comparator<Integer> com = new Comparator<Integer>()
        {
            // sort the elements with the last digits
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 % 10 > o2 % 10) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };

        List<Integer> lt = new ArrayList<>();

        lt.add(10);
        lt.add(15);
        lt.add(13);
        lt.add(11);
        lt.add(21);

        Collections.sort(lt, com);

        System.out.println(lt);
    }
}
