package org.enset.Ex2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}