package com.horstmann.corejava.lab1;

import java.util.Random;
import java.util.Scanner;

public class Task10 {
    public static void main(String[] args){
        System.out.print("Enter ceil number: ");

        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()){
            int charCount = scanner.nextInt();

            if (charCount <= 0) return;

            long randNum;
            Random rnd = new Random();

            do {
                int chunkCount = Math.min(charCount, 10);

                long minNum = (long) Math.pow(36, chunkCount - 1);
                long maxNum = (long) Math.pow(36, chunkCount);

                randNum = rnd.nextLong(minNum, maxNum);

                System.out.print(Long.toString(randNum, 36));

                charCount -= chunkCount;
            } while (charCount > 0);

        } else {
            System.out.println("Number incorrect!");
        }
    }
}
