package com.horstmann.corejava.lab1;

import java.util.ArrayList;
import java.util.Scanner;

public class Task15 {
    public static ArrayList<ArrayList<Integer>> createPascalTriangle(int maxNum){
        ArrayList<ArrayList<Integer>> pascalTriangle = new ArrayList<>();

        boolean numFound = false;
        int rowCounter = 0;

        do {
            pascalTriangle.add(new ArrayList<>());
            rowCounter++;

            int currentIndex = rowCounter - 1;

            ArrayList<Integer> currentRow = pascalTriangle.get(currentIndex);
            currentRow.add(1);

            for (int i = 1; i < currentIndex; i++) {
                ArrayList<Integer> prevRow = pascalTriangle.get(currentIndex - 1);

                int currentNum = prevRow.get(i - 1) + prevRow.get(i);
                currentRow.add(currentNum);

                if (currentNum == maxNum) {
                    numFound = true;
                } else if (currentNum > maxNum) {
                    pascalTriangle.remove(currentIndex);
//                    currentIndex = 0; // set index to first row to avoid writing leading `1`

                    numFound = true;
                    break;
                }
            }

            if (currentIndex != 0) currentRow.add(1);
        } while (!numFound);

        return pascalTriangle;
    }

    public static void printPascalTriangle(int maxNum){
        ArrayList<ArrayList<Integer>> pascalTriangle = createPascalTriangle(maxNum);

        System.out.println("Pascal triangle: ");

        for (ArrayList<Integer> row : pascalTriangle) {
            for (int element : row) {
                System.out.printf("%4d", element);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        System.out.print("Enter Pascal triangle max num: ");

        Scanner in = new Scanner(System.in);

        int maxNum;

        if (in.hasNextInt()) {
            maxNum = in.nextInt();
        } else {
            System.out.println("Number incorrect!");
            return;
        }

        printPascalTriangle(maxNum);
    }
}
