package com.horstmann.corejava.lab1;

import java.util.ArrayList;
import java.util.Scanner;

public class Task14 {
    public static ArrayList<Integer> parseIntRow(String str){
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        if (str.isEmpty())
            return integerArrayList;

        Scanner strScanner = new Scanner(str);

        while (strScanner.hasNextInt()){
            integerArrayList.add(strScanner.nextInt());
        }

        return integerArrayList;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        ArrayList<ArrayList <Integer>> inputMatrix = new ArrayList<>();
        int prevNumCount = -1;

        while (scanner.hasNextLine()){
            String str = scanner.nextLine();

            if (str.isEmpty()) break;

            ArrayList<Integer> newRow = parseIntRow(str);

            if (newRow.size() == 0) {
                System.err.println("Input error!");
                return;
            } else if (prevNumCount != -1 && prevNumCount != newRow.size()) {
                System.err.println("Matrix is not square!");
                return;
            } else {
                inputMatrix.add(newRow);
                prevNumCount = newRow.size();
            }
        }


        if (prevNumCount != inputMatrix.size()) {
            System.err.println("Matrix is not square!");
            return;
        }

        if (isAllEqual(inputMatrix)) {
            System.out.println("Magic square.");
        } else {
            System.out.println("Not magic square.");
        }
    }



    public static boolean isAllEqual(ArrayList<ArrayList <Integer>> inputMatrix){
        int sum = sumDiagonalLeft(inputMatrix);

        if (sumDiagonalRight(inputMatrix) != sum) return false;

        for (ArrayList<Integer> row : inputMatrix) {
            if (sumRow(row) != sum) return false;
        }

        for (int i = 0; i < inputMatrix.size(); i++) {
            if (sumColumn(inputMatrix, i) != sum) return false;
        }

        return true;
    }

    public static int sumRow(ArrayList <Integer> inputRow){
        int sum = 0;

        for (int num:
             inputRow) {
            sum += num;
        }

        return sum;
    }

    public static int sumColumn(ArrayList<ArrayList <Integer>> inputMatrix, int colNum){
        int sum = 0;

        for (ArrayList<Integer> row : inputMatrix) {
            sum += row.get(colNum);
        }

        return sum;
    }

    public static int sumDiagonalLeft(ArrayList<ArrayList <Integer>> inputMatrix){
        int sum = 0;

        for (int i = 0; i < inputMatrix.size(); i++){
            sum += inputMatrix.get(i).get(i);
        }

        return sum;
    }

    public static int sumDiagonalRight(ArrayList<ArrayList <Integer>> inputMatrix){
        int sum = 0;

        for (int i = inputMatrix.size() - 1; i >= 0; i--){
            sum += inputMatrix.get(i).get(i);
        }

        return sum;
    }
}
