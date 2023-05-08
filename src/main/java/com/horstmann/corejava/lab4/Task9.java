package com.horstmann.corejava.lab4;

import com.horstmann.corejava.lab4.task6.DiscountedItem;
import com.horstmann.corejava.lab4.task6.Item;

import java.lang.reflect.Field;
import java.util.StringJoiner;

public class Task9 {
    public static void main(String[] args) throws Exception {
        Item item = new Item("Item", 123.123);
        Item item2 = new DiscountedItem("Item", 123.123,12.12);
        System.out.println(toString(item2));
    }

    public static String toString(Object o) throws Exception {
        Class<?> clazz = o.getClass();
        StringJoiner joiner = new StringJoiner(",", clazz.getName() + "{", "}");
        while (clazz != null) {
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                joiner.add(field.getName() + "=" + field.get(o).toString());
            }
            clazz=clazz.getSuperclass();
        }
        return joiner.toString();
    }
}