package com.horstmann.corejava.lab4;

import com.horstmann.corejava.lab4.task6.Item;

public class Task12 {
    public static void main(String[] args) {
        Item item = new Item("Item", 1);

        long time = System.currentTimeMillis();//получаем начальное время
        for(int i = 0; i < 100000; i++) {
            item.hashCode();
        }
        System.out.println("Regular time:" + (System.currentTimeMillis() - time));//сравниваем с конечным

        try {
            time = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                item.getClass().getMethod("hashCode").invoke(item);
            }
            System.out.println("Reflection time:" + (System.currentTimeMillis() - time));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
