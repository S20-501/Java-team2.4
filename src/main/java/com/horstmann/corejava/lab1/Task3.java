package com.horstmann.corejava.lab1;

import java.util.Scanner;

public class Task3 {
    public static int myMax(int a, int b, int c){
        if (a > b) {
            if (a > c){
                return a;
            } else {
                return b;
            }
        } else {
            if (b > c){
                return b;
            } else {
                return c;
            }
        }
    }

    public static void main(String[] args){
        System.out.print("Enter 3 ceil numbers: ");

        Scanner in = new Scanner(System.in);

        int[] nums = new int[3];

        for (int i = 0; i < 3; i++){
            if (in.hasNextInt()) {
                nums[i] = in.nextInt();
            } else {
                System.out.println("Number incorrect!");
                return;
            }
        }

        System.out.println("Max number is: " + myMax(nums[0], nums[1], nums[2]));

//        System.out.println("Max number is: " + Math.max(Math.max(nums[0], nums[1]), nums[2]));
    }
}
