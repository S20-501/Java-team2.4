package com.horstmann.corejava.lab1;

import java.util.Scanner;

public class Task7 {
    static int fromUnsignedShort(short num){
        return num & 0xFFFF;
    }

    static short plus(short a, short b){
        return (short) (a + b);
    }

    static short minus(short a, short b){
        return (short) (a - b);
    }

    static short mult(short a, short b){
        return (short) (a * b);
    }

    static short divide(short a, short b){
        return (short) ((a & 0xFFFF) / (b & 0xFFFF));
    }

    static short module(short a, short b){
        return (short) ((a & 0xFFFF) % (b & 0xFFFF));
    }

    public static void main(String[] args){
        System.out.print("Enter 2 ceil positive numbers [0..65535]: ");

        Scanner in = new Scanner(System.in);

        short[] nums = new short[2];

        for (int i = 0; i < 2; i++){
            if (in.hasNextInt()) {
                int tmp = in.nextInt();

                if (tmp < 0 || tmp > (Short.MAX_VALUE * 2) + 1) {
                    System.err.println("Number out of range!");
                    return;
                }

                nums[i] = (short) tmp;
            } else {
                System.err.println("Number incorrect!");
                return;
            }
        }

        System.out.println("Numbers: " + nums[0] + " " + nums[1] + " "
                + fromUnsignedShort(nums[0]) + " " + fromUnsignedShort(nums[1]));
        System.out.println("Minus: " + minus(nums[0], nums[1]) + " " + fromUnsignedShort(minus(nums[0], nums[1])));
        System.out.println("Plus: " + plus(nums[0], nums[1]) + " " + fromUnsignedShort(plus(nums[0], nums[1])));
        System.out.println("Multiply: " + mult(nums[0], nums[1]) + " " + fromUnsignedShort(mult(nums[0], nums[1])));

        if (nums[1] == 0) {
            System.err.println("Second number can't be zero (can't divide by zero)!");
            return;
        }
        System.out.println("Division: " + divide(nums[0], nums[1]) + " " + fromUnsignedShort(divide(nums[0], nums[1])));
        System.out.println("Module: " +  module(nums[0], nums[1]) + " " + fromUnsignedShort(module(nums[0], nums[1])));
    }
}


