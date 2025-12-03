package com.collection.learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

public class LearnComparator3 {
    public static void main(String[] args) {

        // at the time of object creation also we can define the method
        Comparator<Student> com = new Comparator<Student>() { // Anonymous Inner Class
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.age > o2.age)
                    return 1;
                else
                    return -1;
            }
        };

        // OR using lambda expression
        Comparator<Student> com1 = (i, j) -> i.age > j.age?1:-1;

        List<Student> list = new ArrayList<>();

        list.add(new Student(21, "Harsh"));
        list.add(new Student(25, "Prashant"));
        list.add(new Student(23, "Akhil"));
        list.add(new Student(27, "Aditya"));

        Collections.sort(list, com1);
        System.out.println(list);
    }
}
