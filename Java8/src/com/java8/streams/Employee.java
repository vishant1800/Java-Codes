package com.java8.streams;

import java.util.Arrays;
import java.util.List;

public class Employee {
    private int id;
    private String name;
    private String dept;

    public Employee() {

    }
    public Employee(int id, String name, String dept) {
        this.id = id;
        this.name = name;
        this.dept = dept;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}

class EmployeeMain {
    public static void main(String[] args) {
        List<Employee> finalList = allEmployees();
    }

    public static List<Employee> allEmployees () {
        Employee emp1 = new Employee(1, "Vishant", "IT");
        Employee emp2 = new Employee(2, "Ajay", "HR");
        Employee emp3 = new Employee(3, "Vijay", "HR");
        Employee emp4 = new Employee(4, "Manish", "IT");
        Employee emp5 = new Employee(5, "Ashley", "IT");

//        System.out.println(emp1.getDept());
        return Arrays.asList(emp1, emp2, emp3, emp4, emp5);
    }
}
