package com.horstmann.corejava.lab3.task14;

import java.util.Arrays;
import java.util.Comparator;


public class Task14 {

    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("AABC", 1),
                new Employee("ADBC", 1),
                new Employee("AADC", 2),
                new Employee("AAAC", 2),
                new Employee("ABCD", 4),
                new Employee("AACD", 4),
                new Employee("ABCD", 3),
                new Employee("AAAA", 3)
        };
        sort(employees);
        for(Employee employee : employees){
            System.out.println(employee.toString());
        }
    }

    private static void sort(Employee[] employees){
        Arrays.sort(employees, Comparator.comparing(Employee::getSalary).reversed().thenComparing(Employee::getName));
    }
}
