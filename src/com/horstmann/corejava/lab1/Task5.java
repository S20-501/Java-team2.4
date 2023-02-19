package com.horstmann.corejava.lab1;
public class Task5 {
    public static void main(String[] args){
        double largeDecimal = Integer.MAX_VALUE;
        largeDecimal += Integer.MAX_VALUE;
        System.out.println("Large double decimal: " + largeDecimal);

        int wrongNum = (int) largeDecimal;

        System.out.println("Large double decimal, converted to int: " + wrongNum);
    }
}
