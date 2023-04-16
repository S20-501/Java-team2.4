package com.horstmann.corejava.lab3;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class Task11 {

    private static final String DIR = System.getProperty("java.io.tmpdir");

    private static String[] listOfFiles(String path, String pattern) {
        return new File(path).list((dir, name) -> name.endsWith(pattern));
    }

    public static void main(String[] args) {
        System.out.println("*.tmp in the folder " + DIR + ":");
        System.out.println(listOfFiles(DIR, ".tmp"));
    }
}
