package com.horstmann.corejava.lab4.Task9;

import com.horstmann.corejava.lab4.task6.DiscountedItem;
import com.horstmann.corejava.lab4.task6.Item;

import java.lang.reflect.Field;
import java.util.*;

public class Task9 {
    private static Set<Integer> alreadyWatched;

    private static final Set<Class<?>> BOX_TYPES;

    static {
        BOX_TYPES = new HashSet<>();
        BOX_TYPES.add(Boolean.class);
        BOX_TYPES.add(Character.class);
        BOX_TYPES.add(Byte.class);
        BOX_TYPES.add(Short.class);
        BOX_TYPES.add(Integer.class);
        BOX_TYPES.add(Long.class);
        BOX_TYPES.add(Float.class);
        BOX_TYPES.add(Double.class);
        BOX_TYPES.add(Void.class);
    }

    public static boolean isBoxType(Class<?> clazz) {
        return BOX_TYPES.contains(clazz);
    }

    public static void main(String[] args) throws Exception {
        Item item = new Item("Item", 123.123);
        Item item2 = new DiscountedItem("Item", 123.123, 12.12);

        Cl1 class1 = new Cl1();
        Cl2 class2 = new Cl2();
        class1.otherClass = class2;
        class2.otherClass = class1;
        Integer a = 4;
        int[] mass = {1, 2, 3};
        System.out.println(toString(class1));
    }


    synchronized public static String toString(Object o) throws IllegalAccessException {
        boolean isFirst = false;
        if (alreadyWatched == null) {
            alreadyWatched = new HashSet<>();
            isFirst = true;
        }
        if (alreadyWatched.contains(o.hashCode()))
            return null;
        alreadyWatched.add(o.hashCode());
        Class<?> clazz = o.getClass();
        StringJoiner joiner = new StringJoiner(",", clazz.getName() + "{", "}");
        if (clazz.isArray()) {
            joiner.add(o.toString());
        } else if (clazz.isPrimitive() || clazz.getSimpleName().equals("String") || isBoxType(clazz)) {
            joiner.add(o.toString());
        } else {
            while (clazz != null) {
                for (Field field : clazz.getDeclaredFields()) {
                    field.setAccessible(true);
                    Class<?> fieldClazz = field.getType();
                    if (fieldClazz.isArray()) {
                        //joiner.add(field.getName() + "=" + Arrays.toString((Object[]) field.get(field)));
                        joiner.add(field.getName() + "=" + field.toString());
                    } else if (fieldClazz.isPrimitive() || fieldClazz.getSimpleName().equals("String") || isBoxType(fieldClazz))
                        joiner.add(field.getName() + "=" + field.get(o).toString());
                    else {
                        String result = toString(field.get(o));
                        if (result != null)
                            joiner.add(result);
                    }
                }
                clazz = clazz.getSuperclass();
            }
        }
        if (isFirst)
            alreadyWatched = null;
        return joiner.toString();
    }
}