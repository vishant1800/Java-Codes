package com.collection.emp;


import java.util.Objects;


class Employee {
        int emp_id;
        String emp_name;
        String designation;
        double salary;

        public Employee(int emp_id, String emp_name, String designation, double salary) {
            this.emp_id = emp_id;
            this.emp_name = emp_name;
            this.designation = designation;
            this.salary = salary;
        }

        public int getEmp_id() {
            return emp_id;
        }

        public String getEmp_name() {
            return emp_name;
        }

        public String getDesignation() {
            return designation;
        }

        public double getSalary() {
            return salary;
        }




    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return emp_id == employee.emp_id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(emp_id + 10);
    }

    @Override
        public String toString() {
            return "Employee{" +
                    "emp_id=" + emp_id +
                    ", emp_name='" + emp_name + '\'' +
                    ", designation='" + designation + '\'' +
                    ", salary=" + salary +
                    '}';
        }
}

