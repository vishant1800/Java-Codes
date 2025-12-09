package com.java8.streams.practice;

import java.util.ArrayList;
import java.util.List;

public class NewEmployee {
    private int id;
    private String name;
    private String dept;
    private double salary;
    private List<String> skills = new ArrayList<>();

    public NewEmployee(int id, String name, String dept, double salary, List<String> skills) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public double getSalary() {
        return salary;
    }

    public List<String> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "NewEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                ", skills=" + skills +
                '}';
    }
}
