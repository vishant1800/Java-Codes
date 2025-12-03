package com.collection.learn;

import java.util.*;

public class LearnLinkedList {
    public static void main(String[] args) {
        List<String> fruits = new LinkedList<>();

        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Grapes");

        // Print all elements
        System.out.println("Fruits List: " + fruits);

        // Adding element at first and last
        fruits.addFirst("Strawberry");
        fruits.addLast("Orange");
        System.out.println("After adding first & last: " + fruits);

        // Accessing elements
        System.out.println("First fruit: " + fruits.getFirst());
        System.out.println("Last fruit: " + fruits.getLast());
        System.out.println("Fruit at index 2: " + fruits.get(2));

        // Removing elements
        fruits.removeFirst();  // removes first element
        fruits.removeLast();   // removes last element
        fruits.remove("Mango"); // removes Mango
        System.out.println("After removals: " + fruits);

        // Iterating using for-each loop
        System.out.println("\nIterating with for-each:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Iterating using Iterator
        System.out.println("\nIterating with Iterator:");
        Iterator<String> it = fruits.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // Checking size
        System.out.println("\nTotal fruits: " + fruits.size());

        // Checking if list contains an element
        System.out.println("Contains Banana? " + fruits.contains("Banana"));

        System.out.println();
    }
}

