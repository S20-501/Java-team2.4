package com.horstmann.corejava.lab1;

import java.util.Scanner;
public class Task1 {
    public static void main(String[] args) {
        System.out.print("Enter ceil number: ");

        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()){
            int num = scanner.nextInt();

            System.out.printf("Binary number: 0b%s\n", Integer.toString(num, 2));
            System.out.printf("Octal number: 0%o\n", num);
            System.out.printf("Hexademical number: 0x%X\n", num);

            System.out.printf("Inverse number in hexademical: %A\n", 1.0 / num);
        } else {
            System.out.println("Number incorrect!");
        }
    }
}