package com.horstmann.corejava.lab1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Task13 {
    public static int[] chooseLuckyNumbers(ArrayList<Integer> numList){
        int[] luckyNumbers = new int[6];
        Random rnd = new Random();
        int luckyIndex;

        for (int i = 0; i < luckyNumbers.length; i++){
            luckyIndex = rnd.nextInt(numList.size());

            luckyNumbers[i] = numList.get(luckyIndex);

            numList.remove(luckyIndex);
        }

        Arrays.sort(luckyNumbers);

        return luckyNumbers;
    }

    public static void main(String[] args){
        ArrayList<Integer> numList = new ArrayList<>(49);

        for (int i = 1; i <= 49; i++){
            numList.add(i);
        }

        System.out.print("Lucky numbers: " + Arrays.toString(chooseLuckyNumbers(numList)));
    }
}
