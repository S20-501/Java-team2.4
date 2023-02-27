package com.horstmann.corejava.lab1;

import java.util.ArrayList;
import java.util.Scanner;

public class Task16 {
    public static double average(double num1, double... others){
        double sum;

        sum = num1;

        for (double num:
             others) {
            sum += num;
        }

        return sum / (others.length + 1);
    }

    public static double[] listToDoubleArray(ArrayList<Double> numList){
        double[] numArray = new double[numList.size()];

        int i = 0;
        for (double num:
                numList) {
            numArray[i] = num;
            i++;
        }

        return numArray;
    }

    public static void main(String[] args){
        System.out.print("Enter ceil numbers for averaging (string for end of input): ");

        Scanner in = new Scanner(System.in);

        ArrayList<Double> numList = new ArrayList<>();

        while (true){
            if (in.hasNextDouble()) {
                numList.add(in.nextDouble());
            } else {
                break;
            }
        }

        double num1 = numList.get(0);
        numList.remove(0);

        System.out.println("Numbers average: " + average(num1, listToDoubleArray(numList)));
    }
}
