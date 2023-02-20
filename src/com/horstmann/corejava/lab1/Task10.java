package com.horstmann.corejava.lab1;

import java.math.BigDecimal;
import java.util.Random;
import java.util.Scanner;

public class Task10 {
    public static void main(String[] args){
        BigDecimal test;

        System.out.print("Enter ceil number: ");

        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()){
            int num1 = scanner.nextInt();

            if (num1 <= 0) return;

            long randNum;

            do {
                int num = Math.min(num1, 10);

                long minNum = (long) Math.pow(36, num - 1);
                long maxNum = (long) Math.pow(36, num);


                if (maxNum == minNum){
                    System.err.println("Too high for long number");
                    return;
                }

                Random rnd = new Random();

                randNum = rnd.nextLong(minNum, maxNum);

                System.out.print(Long.toString(randNum, 36));

                num1 -= num;
            } while (num1 > 0);

        } else {
            System.out.println("Number incorrect!");
        }
    }
}
