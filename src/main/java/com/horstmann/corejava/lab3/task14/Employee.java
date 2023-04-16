package com.horstmann.corejava.lab3.task14;

public class Employee{
    private String name;
    private double salary;
    Employee(String name,double salary){
        this.salary = salary;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "name " + name + " salary=" + salary;
    }
}
