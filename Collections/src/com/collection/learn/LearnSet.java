package com.collection.learn;

import java.util.HashSet;
import java.util.Set;

public class LearnSet {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        //Add element
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);

        //it does not contain or adds any duplicate value
        set.add(1);
        set.add(1);
        set.add(1); // elements will be 5 only

        System.out.println(set); // elements will be displayed in unordered form, maybe different everytime

        set.remove(4);
        System.out.println(set);

        System.out.println(set.contains(3)); // returns true or false

        System.out.println(set.isEmpty()); // this will check whether set is empty or not, returns true or false

        System.out.println(set.size());

//        set.clear(); //removes all the elements from the set
//        System.out.println(set); // []
    }
}
