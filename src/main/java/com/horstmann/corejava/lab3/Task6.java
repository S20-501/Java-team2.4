package com.horstmann.corejava.lab3;

import java.util.Iterator;

public class Task6 {
    static class DigitSequence implements Iterator<Integer>{
        int current = 1;

        public boolean hasNext() {
            return true;
        }
        public Integer next() {
            return current++;
        }
        public void remove() {
        }

    }

    public static void main(String[] args) {
        DigitSequence digitSequence = new DigitSequence();

        System.out.print("Print first 10 elements of sequence: ");

        for (int i = 0; i < 10; i++) {
            System.out.print(digitSequence.next() + " ");
        }

        System.out.println();
    }
}
