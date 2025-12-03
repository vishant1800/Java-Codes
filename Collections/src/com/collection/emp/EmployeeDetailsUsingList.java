package com.collection.emp;

import java.util.*;

class EmployeeDetailsUsingList {
    public static void main(String[] args) {
        Set<Employee> emp = new TreeSet<>();

        emp.add(new Employee(101, "Vishant", "Software developer", 1000000));
        emp.add(new Employee(102, "Prashant", "Software tester", 500000));
        emp.add(new Employee(103, "Sameer", "Business Analyst", 100000));
        emp.add(new Employee(103, "Rohit", "Business Analyst", 100000));
        // Displaying all the employees details
        for (Employee e : emp) {
            System.out.println(e);
        }

        // Employee Details: Search for specific employee id
//        System.out.println("\nEmployee details with specific ");
//        int searchId = 102;
//        for (Employee e : emp) {
//            if (e.getEmp_id() == searchId) {
//                System.out.println(e);
//            }
//        }
    }
}
