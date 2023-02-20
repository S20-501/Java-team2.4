package com.horstmann.corejava.lab1;

import java.util.Random;
import java.util.Scanner;

public class Task10 {
    public static void main(String[] args){
        System.out.print("Enter ceil number: ");

        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()){
            int num = scanner.nextInt();

            if (num <= 0) return;

            long randNum;

            long minNum = (long) Math.pow(36, num - 1);
            long maxNum = (long) Math.pow(36, num);

            if (maxNum == minNum){
                System.err.println("Too high for long number");
                return;
            }

            Random rnd = new Random();

            randNum = rnd.nextLong(minNum, maxNum);

            System.out.println(Long.toString(randNum, 36));
        } else {
            System.out.println("Number incorrect!");
        }
    }
}
