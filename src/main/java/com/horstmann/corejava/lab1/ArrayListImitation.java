package com.horstmann.corejava.lab1;

import java.util.Arrays;

public class ArrayListImitation {
     public static void main(String[] args) {
        String[] arr = new String[8];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(i);
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(arr.length);

        String[] newArr = addToTheEnd(arr, arr.length - 1, "test");

        System.out.println(Arrays.toString(newArr));
        System.out.println(newArr.length);
    }

    public static String[] addToTheEnd(String[] arr,long capacity,String el){

        if (capacity+1 == arr.length)
            arr = grow((capacity+1),arr);
        arr[(int) capacity] = el;
        return arr;
    }

    private static String[] grow(long minCapacity, String[] arr) {
        int oldCapacity = arr.length;
        int newCapacity = (int) ((oldCapacity) + Math.max((minCapacity - oldCapacity), oldCapacity >> 1));
        return arr = Arrays.copyOf(arr, newCapacity);
    }
}
