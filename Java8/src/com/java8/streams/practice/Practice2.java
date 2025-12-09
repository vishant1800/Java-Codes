package com.java8.streams.practice;

import com.java8.streams.Employee;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

public class Practice2 {
    public static void main(String[] args) {
        List<NewEmployee> employeeList = employees();
//        Q1. Group employees by department
//        Create a Map<String, List<Employee>> where key = department name, value = list of employees in that dept.

//        Map<String, List<NewEmployee>> collect = employeeList.stream()
//                .collect(Collectors.groupingBy(NewEmployee::getDept))   ;
//        collect.forEach((key, value) ->
//                System.out.println(key + "\n" + value));

//        Q2. Group employees by department, but store only names
//        Create a Map<String, List<String>> where key = department name, value = list of employee names in that dept.
        Map<String, List<String>> collect1 = employeeList.stream()
                .collect(Collectors.groupingBy(NewEmployee::getDept,
                        Collectors.mapping(NewEmployee::getName, Collectors.toList())));
        System.out.println(collect1);

//        Q3. Count employees in each department
//        Create a Map<String, Long> where key = dept, value = count of employees in that dept.
        Map<String, Long> collect3 = employeeList.stream()
                .collect(Collectors.groupingBy(NewEmployee::getDept, Collectors.counting()));
        System.out.println(collect3);

//        Q4. Average salary per department
//        Create a Map<String, Double> where key = dept, value = average salary of employees in that dept.
        Map<String, Double> collect4 = employeeList.stream()
                .collect(Collectors.groupingBy(NewEmployee::getDept,
                        Collectors.averagingDouble(NewEmployee::getSalary)));
        System.out.println(collect4);

//        Q5. Highest salary employee in each department
//        Create a Map<String, Employee> where key = dept, value = the employee with the highest salary in that dept.
        Map<String, Optional<NewEmployee>> collect5 = employeeList.stream()
                .collect(Collectors.groupingBy(NewEmployee::getDept,
                        Collectors.maxBy(Comparator.comparing(NewEmployee::getSalary))));
        collect5.forEach((key,value) -> {
            System.out.println(key + "\n" +value.get());
        });

//        Q6. Department with maximum number of employees
//        Find the department name (String) that has the most employees.


    }

    public static List<NewEmployee> employees () {
        NewEmployee e1 = new NewEmployee(
                1, "Vishant", "IT", 85000,
                Arrays.asList("Java", "Spring Boot", "SQL")
        );

        NewEmployee e2 = new NewEmployee(
                2, "Rohan", "IT", 95000,
                Arrays.asList("React", "Node.js", "JavaScript")
        );

        NewEmployee e3 = new NewEmployee(
                3, "Priya", "HR", 55000,
                Arrays.asList("Communication", "Recruitment")
        );

        NewEmployee e4 = new NewEmployee(
                4, "Manish", "Finance", 70000,
                Arrays.asList("Excel", "Tally", "Accounting")
        );

        NewEmployee e5 = new NewEmployee(
                5, "Ayesha", "HR", 60000,
                Arrays.asList("Communication", "Excel")
        );

        NewEmployee e6 = new NewEmployee(
                6, "Suresh", "IT", 120000,
                Arrays.asList("Java", "Microservices", "AWS")
        );

        NewEmployee e7 = new NewEmployee(
                7, "Neha", "Marketing", 65000,
                Arrays.asList("Content Writing", "SEO")
        );

        NewEmployee e8 = new NewEmployee(
                8, "Aman", "Finance", 95000,
                Arrays.asList("Excel", "Power BI", "SQL")
        );

        NewEmployee e9 = new NewEmployee(
                9, "Kiran", "Marketing", 70000,
                Arrays.asList("Digital Marketing", "Communication")
        );

        NewEmployee e10 = new NewEmployee(
                10, "Ashley", "IT", 110000,
                Arrays.asList("Python", "Django", "AWS")
        );

        return Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
    }
}
