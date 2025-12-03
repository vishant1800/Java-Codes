package com.collection.emp;

import java.util.HashMap;
import java.util.Map;

public class EmployeeDetailsUsingMap {
    public static void main(String[] args) {

        Map<Integer, Employee> employeeMap = new HashMap<>();

        employeeMap.put(101, new Employee(101, "Vishant", "Software Developer", 45000));
        employeeMap.put(102, new Employee(102, "Rohit", "Tester", 30000));
        employeeMap.put(103, new Employee(103, "Anita", "Project Manager", 65000));

        // Displaying all employees
        System.out.println("Employee Details:");
        for (Employee emp : employeeMap.values()) {
            System.out.println(emp);
        }

        // Searching employee by ID
        int searchId = 102;
        if (employeeMap.containsKey(searchId)) {
            System.out.println("\nEmployee found: " + employeeMap.get(searchId));
        } else {
            System.out.println("\nEmployee not found!");
        }
    }
}
