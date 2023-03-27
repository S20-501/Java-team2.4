package com.horstmann.corejava.lab2;

import org.omg.CORBA.IntHolder;

import static java.lang.System.out;

public class Task4 {

    //Не получится, так как создаются копии
    public static void swap(int a, int b) {
        int c = a;
        a = b;
        b = c;
    }

    //Не получится, так как создаются копии
    public static void swap(Integer a, Integer b) {
        Integer c = a;
        a = b;
        b = c;
    }



    //Получится, так как это динамические объекты и в функцию приходят не копии, а ссылки на объекты
    public static void swap(IntHolder a, IntHolder b) {
        int c = a.value;
        a.value = b.value;
        b.value = c;
    }

    public static void main(String[] args) {
        int a = -1;
        int b = 1;
        swap(a, b);
        out.println("a = " + a + "\nb = " + b);

        Integer a1 = -1;
        Integer b1 = 1;
        swap(a1, b1);
        out.println("a = " + a1 + "\nb = " + b1);

        IntHolder a2 = new IntHolder();
        IntHolder b2 = new IntHolder();
        a2.value = -1;
        b2.value = 1;
        swap(a2,b2);
        System.out.println("a = " + a2.value + "\nb = " + b2.value);
    }
}
