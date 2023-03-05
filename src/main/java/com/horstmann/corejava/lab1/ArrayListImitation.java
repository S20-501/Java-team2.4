package com.horstmann.corejava.lab1;

import java.util.Arrays;

public class ArrayListImitation {
    /**
     * @author Nikita Sazikov
     */
    public static String[] addToTheEnd(String[] arr,long capacity,String el){

        if (capacity == arr.length)
            arr = grow((capacity+1),arr);


        arr[(int) capacity] = el;
        //  size = s + 1;
        return arr;
    }

    /**
     * @author Nikita Sazikov
     */
    private static String[] grow(long minCapacity, String[] arr) {
        int oldCapacity = arr.length;
        int newCapacity = (int) ((oldCapacity) + Math.max((minCapacity - oldCapacity), oldCapacity >> 1));
        return Arrays.copyOf(arr, newCapacity);
    }

    /**
     * @author Evgeny Ezers
     */
    public static void main(String[] args){
        String[] arr = new String[8];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(i);
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(arr.length);

        String[] newArr = addToTheEnd(arr, arr.length - 1, "test");

        System.out.println(Arrays.toString(newArr));
        System.out.println(newArr.length);

        String[] newArr2 = addToTheEnd(arr, arr.length, "test2");

        System.out.println(Arrays.toString(newArr2));
        System.out.println(newArr2.length);
    }
}
