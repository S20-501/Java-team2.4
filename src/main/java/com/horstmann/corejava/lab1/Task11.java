package com.horstmann.corejava.lab1;

import java.util.Scanner;

public class Task11 {
    public static void main(String[] args){
        System.out.print("Enter string: ");

        Scanner in = new Scanner(System.in);

        String str;

        if (in.hasNextLine()){
            str = in.nextLine();
        } else {
            System.out.println("String incorrect!");
            return;
        }

        System.out.println("Chars:");
        for (char ch:
                str.toCharArray()) {
            System.out.printf( "%c - %d\n", ch, (int) ch);
        }

        System.out.println("Code points:"); // 🖑🖔hjk
        for (int codePoint:
            str.codePoints().toArray()) {
            System.out.printf("%c - %d\n", codePoint, codePoint);
        }
    }
}
