package com.java8.concepts;

import com.java8.concepts.lambda.Employee;

public class AnonymousInnerClass {
    public static void main(String[] args) {
        Employee emp = new Employee() {
            @Override
            public String getName() {
                return "Raj";
            }
        };

        System.out.println(emp.getName());
    }
}
