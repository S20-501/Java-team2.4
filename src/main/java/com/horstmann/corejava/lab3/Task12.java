package com.horstmann.corejava.lab3;

import com.horstmann.corejava.lab3.MyComparator.MyComparator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task12 {
    public static void main(String[] args) {
        File file1 = new File("/home/evezers/input.txt");

        Scanner inFile;

        try {
            inFile = new Scanner(file1);
        } catch (FileNotFoundException e){
            System.out.println("Input file not found");
            return;
        }

        ArrayList<File> files = new ArrayList<>();

        while (inFile.hasNextLine()){
            files.add(new File(inFile.nextLine()));
        }

        System.out.println("Unsorted list of files:");

        for (File file:
                files) {
            System.out.println(file.getPath());
        }

        files.sort(MyComparator
                .comparing(File::isFile)
                .thenComparing(File::getPath));

        System.out.println();
        System.out.println("Sorted list of files:");

        for (File file:
             files) {
            System.out.println(file.getPath());
        }
    }
}
