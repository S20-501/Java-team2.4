package com.horstmann.corejava.lab1;

import java.math.BigInteger;
import java.util.Scanner;

public class Task6 {
    public static BigInteger bigFactorial(int num){
        BigInteger factorial = new BigInteger(String.valueOf(1));

        for (int i = 1; i <= num; i++){
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial;
    }

    public static void main(String[] args){
        System.out.print("Enter ceil positive n of factorial: ");

        Scanner in = new Scanner(System.in);

        int num;

        if (in.hasNextInt()) {
            num = in.nextInt();
        } else {
            System.out.println("Number incorrect!");
            return;
        }

        if (num < 0) {
            System.out.println("Number must be positive!");
            return;
        }

        

        System.out.println(num + "! = " + bigFactorial(num));
    }
}
