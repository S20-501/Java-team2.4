package com.horstmann.corejava.lab3;

import java.util.Random;

public class Task15 {
    public interface IntSequence {
        boolean hasNext();

        int next();
    }

    static class RandomSequence implements IntSequence {
        int low;
        int high;
        Random generator;

        RandomSequence(int low, int high, Random generator){
            this.low = low;
            this.high = high;
            this.generator = generator;
        }

        public int next() { return low + generator.nextInt(high - low + 1);}
        public boolean hasNext() { return true; }
    }

    private static final Random generator = new Random();

    public static IntSequence randomInts(int low, int high) {
        return new RandomSequence(low, high, generator);
    }

    public static void main(String[] args) {
        IntSequence digitSequence = randomInts(1, 100);

        System.out.print("Print first 10 elements of sequence: ");

        for (int i = 0; i < 10; i++) {
            System.out.print(digitSequence.next() + " ");
        }

        System.out.println();
    }
}
