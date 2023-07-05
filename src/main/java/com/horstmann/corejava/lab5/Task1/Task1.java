package com.horstmann.corejava.lab5.Task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.NumberFormatException;

public class Task1 {

    public static ArrayList<Double> readValues(String filename) throws FileNotFoundException, NumberFormatException {
        //File resource = new File(root, "filename.ext");
        ArrayList<Double> result = new ArrayList<>();
        double currentNumber;
        FileInputStream input = new FileInputStream("./src/main/java/com/horstmann/corejava/lab5/Task1/"+ filename);
        Scanner scanner = new Scanner(input);
        while (scanner.hasNext()){
            currentNumber = Double.valueOf(scanner.nextLine());
            if(currentNumber == Math.ceil(currentNumber))
                throw new NumberFormatException("A number without a floating point: " + (long)currentNumber);
            result.add(currentNumber);
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Double> res;
        try {
            res = readValues("Data");
            System.out.println(res);
        }catch (FileNotFoundException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
