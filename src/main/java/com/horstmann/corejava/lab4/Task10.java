package com.horstmann.corejava.lab4;

import java.util.Arrays;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Task10 {
    public static void main(String[] args) {
        Class<?> cl;
        try {
            cl = Class.forName(int[].class.getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (cl != null) {
            for (Method m : cl.getDeclaredMethods()) {
                System.out.println(Modifier.toString(m.getModifiers()) + " " +
                        m.getReturnType().getCanonicalName() + " " +  m.getName() +
                        Arrays.toString(m.getParameters()));
            }
            cl = cl.getSuperclass();
        }
    }
}
