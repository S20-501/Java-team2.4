package com.horstmann.corejava.lab4;

import java.util.function.DoubleFunction;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Task13 {
    static void printValuesMethod(Method method, double from, double to, double step) {
        for (double current = from; current < to; current += step){
            try {
                System.out.println(method.invoke(null, current));
            } catch (InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static void printValuesObject(DoubleFunction<Object> function, double from, double to, double step){
        for(double current = from; current < to; current += step){
            System.out.println(function.apply(current));
        }
    }

    public static void main(String[] args) {
        Method method;

        try{
            method = Math.class.getMethod("sqrt", double.class);
        } catch(NoSuchMethodException e){
            throw new RuntimeException(e);
        }

        System.out.println("Method: " + method.getName());
        printValuesMethod(method, 1, 7, 1.1);
        System.out.println();


        try{
            method = Double.class.getMethod("toHexString", double.class);
        } catch(NoSuchMethodException e){
            throw new RuntimeException(e);
        }

        System.out.println("Method: " + method.getName());
        printValuesMethod(method, 2, 8, 1.2);
        System.out.println();



        System.out.println("Object: sqrt");
        printValuesObject(Math::sqrt, 3, 9, 1.3);
        System.out.println();

        System.out.println("Object: toHexString");
        printValuesObject(Double::toHexString, 4, 10, 1.4);
        System.out.println();
    }
}
