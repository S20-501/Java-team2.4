package com.horstmann.corejava.lab4;

import java.util.LinkedList;
import java.util.Queue;

public class Task8 {
    private static void printInfo(Class<?> someClass) {
        System.out.println(
                "toString:  " + someClass.toString() + '\n'
                        + "toGenericString:  " + someClass.toGenericString() + '\n'
                        + "descriptorString:  " + someClass.descriptorString() + '\n'
                        + "getCanonicalName:  " + someClass.getCanonicalName() + '\n'
                        + "getSimpleName:  " + someClass.getSimpleName() + '\n'
                        + "getTypeName:  " + someClass.getTypeName() + '\n'
        );
    }
    // Внутренний класс
    private class Inner {
        public void print() {
            System.out.println("Это внутренний класс");
        }
    }

    public static void main(String[] args) {
        Class<?>[] objects = {
                String[].class,//массив
                new LinkedList<>().getClass(),//обобщенный тип
                Task8.Inner.class,//внутренний класс
                int.class,//примитивный тип
        };


        for (Class<?> obj : objects) {
            System.out.println("-------------- Name: " + obj.getName());
            printInfo(obj);
        }

    }
}