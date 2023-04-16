package com.horstmann.corejava.lab3.task_4_5;

import com.horstmann.corejava.lab3.task_4_5.IntSequence;

public class Task5 {
    public static void main(String[] args) {
        System.out.println("проверка работы через лямбда-выражение:");
        IntSequence Sequence = IntSequence.constantLambda(1);
        System.out.println(Sequence.hasNext());
        for(int i=0;i<6;i++)
            System.out.println(Sequence.next());
        System.out.println(Sequence.hasNext());

        System.out.println("проверка работы через возврат анонимного класса:");
        Sequence = IntSequence.constant(2);
        System.out.println(Sequence.hasNext());
        for(int i=0;i<6;i++)
            System.out.println(Sequence.next());
        System.out.println(Sequence.hasNext());
    }
}
