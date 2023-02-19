package com.horstmann.corejava.lab1;

import java.util.Scanner;

public class Task8 {
    public static void printAllSubstrings(String str){
        for (int i = 0; i < str.length(); i++){
            for (int j = i; j < str.length() + 1; j++){
                String subString = str.substring(i, j);

                if (!subString.isEmpty()) {
                    System.out.printf("'%s'\n", subString);
                }
            }
        }
    }

    public static void main(String[] args){
        System.out.print("Enter string: ");

        Scanner in = new Scanner(System.in);

        if (in.hasNextLine()){
            String str = in.nextLine();
            printAllSubstrings(str);
        } else {
            System.out.println("String incorrect!");
        }
    }
}
