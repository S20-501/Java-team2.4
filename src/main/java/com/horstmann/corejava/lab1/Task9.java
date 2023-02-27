package com.horstmann.corejava.lab1;

import java.util.Scanner;

public class Task9 {
    public static int stringCompare(String str1, String str2){
        if (str1.length() != str2.length()){

            return -1;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)){
                System.out.println("Strings not equal in content.");
                return -2;
            }
        }

        return 0;
    }

    public static void main(String[] args){
        System.out.print("Enter string1: ");

        Scanner in = new Scanner(System.in);

        String str1;
        String str2;

        if (in.hasNextLine()){
            str1 = in.nextLine();
        } else {
            System.err.println("String incorrect!");
            return;
        }

        System.out.print("Enter string2: ");

        if (in.hasNextLine()){
            str2 = in.nextLine();
        } else {
            System.err.println("String incorrect!");
            return;
        }

//        switch (stringCompare(str1, str2)){
//            case -1:
//                System.out.println("Strings not equal in length.");
//                break;
//
//            case -2:
//                System.out.println("Strings not equal in content.");
//                break;
//
//            case 0:
//                System.out.println("Strings equal.");
//                break;
//        }

        switch (stringCompare(str1, str2)) {
            case -1 -> System.out.println("Strings not equal in length.");
            case -2 -> System.out.println("Strings not equal in content.");
            case 0 -> System.out.println("Strings equal.");
        }
    }
}
