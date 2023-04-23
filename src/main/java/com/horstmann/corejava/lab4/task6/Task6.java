package com.horstmann.corejava.lab4.task6;

/*
    Симметричность - В частности, в результате вызовов х.equals(у) и у.equals(х)
     для непустых значений х и у должно быть возвращено одно и то же значение.

    не Транзитивность - способность обнаруживать сочетание товаров по обычной цене и со скидкой,
     чтобы делать вызовы х.equals(у) и у.equals(z), но не х.equals(z).
 */

public class Task6 {
    public static void main(String[] args) {
        DiscountedItem x = new DiscountedItem("item", 1, 0.05);
        Item y = new Item("item", 1);
        DiscountedItem z = new DiscountedItem("item", 1, 0.1);

        System.out.println("x.equals(y) = " + x.equals(y)); // true
        System.out.println("y.equals(z) = " + y.equals(z)); // true
        System.out.println("x.equals(z) = " + x.equals(z)); // false
    }
}
