package com.horstmann.corejava.lab1;

import java.util.Scanner;
public class Task2 {

    public static int normalizeAngle(int angle){
//        return (angle % 359 + 359) % 359;
        return Math.floorMod(angle, 359);
    }

    public static void main(String[] args){
        System.out.print("Enter ceil angle: ");

        Scanner in = new Scanner(System.in);

        if (in.hasNextInt()){
            int angle = in.nextInt();

            int normalizedAngle = normalizeAngle(angle);

            System.out.println("Normalized angle (from 0 to 359): " + normalizedAngle);
        } else {
            System.out.println("Number incorrect!");
        }
    }
}
