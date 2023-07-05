package com.horstmann.corejava.lab4;

import java.lang.reflect.Field;



public class ReflectionExample {
    private int field_1 = 1;
    private int field_2 = 2;
    private int field_3 = 3;
    private int field_4 = 4;
    private int field_5 = 5;
    private int field_6 = 6;

    //.......

    private int field_n = 100;

    public static void main(String[] args) throws IllegalAccessException {
        //Например для вывода в лог нужно перечислять все поля
        ReflectionExample example = new ReflectionExample();

        //без рефлексии
//        System.out.println("Field1: " + example.field_1);
//        System.out.println("Field2: " + example.field_2);
//        System.out.println("Field3: " + example.field_3);
//        System.out.println("Field4: " + example.field_4);
//        System.out.println("Field5: " + example.field_5);
//        System.out.println("Field6: " + example.field_6);
//        System.out.println("Fieldn: " + example.field_n);


        //с рефлексией
        for (Field field : example.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            System.out.println(field.getName() + ": " + field.get(example));
        }
    }

}
