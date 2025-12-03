package com.java8.concepts.lambda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //1st way
//        Employee emp = new SoftwareEngineer();
//        System.out.println(emp.getName());

        //2nd way using lambda expression and it will only work for functional interface
        // using lambda expression we can write the implementation of the abstract method here
//        Employee emp1 = () -> "Tester";
//        System.out.println(emp1.getName());

//        Employee emp2 = () -> "HR";
//        System.out.println(emp2.getName());


        // Threads using Lambda Expression
        // 1st way without lambda and using implementation class
//        Myclass myclass = new Myclass();
//        Thread thread = new Thread(myclass);
//        thread.start();

        // 2nd way using lambda
        // Using lambda we are actually writing the implementation of run() method
        // Runnable is a functional interface because it has only one abstract method run()
//        Runnable runnable = () -> {
//            for (int i = 0; i < 5; i++) {
//                System.out.println("Hello Main: " + i);
//            }
//        };
//
//        Thread childThread = new Thread(runnable);
//        childThread.start();


        // Comparator using lambda expression
        List<Integer> list = new ArrayList<>();
        list.add(13);
        list.add(15);
        list.add(11);
        list.add(90);
        list.add(10);

        // without using lambda
        // Collections.sort(list, new ComparatorDemo());

        // using lambda
        Collections.sort(list, (a, b) -> b - a); // sorts in descending order, this is the
        //implementation of compare()
        System.out.println(list);

    }
}