package com.horstmann.corejava.lab2;

import java.util.ArrayList;
import java.util.Random;

public class Task10 {

    public static class RandomNumbers {
        private static final Random generator = new Random();
        public static int nextInt(int low, int high) {
            return low + generator.nextInt(high - low + 1);
            // Ok to access the static generator variable
        }

        static int randomElement(int[] array){
            if (array.length == 0){
                return 0;
            }

            return array[nextInt(0, array.length - 1)];
        }

        static int randomElement(ArrayList<Integer> arrayList){
            if (arrayList.size() == 0){
                return 0;
            }

            return arrayList.get(nextInt(0, arrayList.size() - 1));
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};

        System.out.println(RandomNumbers.randomElement(arr));

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 56; i < 68; i++) {
            arrayList.add(i);
        }

        System.out.println(RandomNumbers.randomElement(arrayList));
    }



}
