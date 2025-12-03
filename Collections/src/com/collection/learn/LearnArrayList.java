package com.collection.learn;

import java.util.ArrayList;
import java.util.List;

public class LearnArrayList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(); // list
        ArrayList<Integer> arr = new ArrayList<>(10);
        ArrayList emp = new ArrayList(); // to store heterogenous values in arraylist
        emp.add("hello");
        emp.add(123);

        System.out.println(emp);
//        List<Integer> arr2 = new ArrayList<>(); // we can also create arraylist like this
        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(10);
        arr.add(60);
        arr.add(50);
        arr.add(1, 40); //insert 40 at index 1 and whatever was present at index 1 is now at index 2

        System.out.println(arr);
        System.out.println(arr.get(2)); //get element at index 2

//        Remove method
        arr.remove(1);
        arr.remove(Integer.valueOf(30));
//        arr.clear(); // remove all elments from the array

        System.out.println(arr);

//       Updation
        arr.set(2, 30); //this will set or replace the value as 30 at index 2
        arr.add(1, 15); // add 15 at index 1 and move the rest of the elements to the right
        System.out.println(arr);

        for (int a : arr) {
            System.out.println(a);
        }

    }
}
