package com.collection.learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student1 implements Comparable<Student1> {
    int age;
    String name;

    public Student1(int age, String name) {
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

    public int compareTo(Student1 s){
        if (this.age > s.age) {
            return 1;
        } else {
            return -1;
        }
    }
}

public class LearnComparable {
    public static void main(String[] args) {

        List<Student> studs = new ArrayList<>();

        studs.add(new Student(21, "Harsh"));
        studs.add(new Student(25, "Prashant"));
        studs.add(new Student(23, "Akhil"));
        studs.add(new Student(27, "Aditya"));

        for(Student s : studs) { // enhanced for-loop
            System.out.println(s);
        }
    }
}
