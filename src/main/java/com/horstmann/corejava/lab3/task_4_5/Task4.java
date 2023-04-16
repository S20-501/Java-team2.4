package com.horstmann.corejava.lab3.task_4_5;

public class Task4 {
    public static void main(String[] args) {
        //проверка работы статического метода of из интерфейса
        IntSequence newSequence = IntSequence.of(3, 1, 4, 1, 5, 9);
        System.out.println(newSequence.hasNext());
        for(int i=0;i<6;i++)
            System.out.println(newSequence.next());
        System.out.println(newSequence.hasNext());
    }
}
