package com.horstmann.corejava.lab1;

import java.util.Random;

public class Task10 {
    public static void main(String[] args){
        System.out.print(Long.toString(new Random().nextLong(Long.MAX_VALUE), 36));
    }
}
