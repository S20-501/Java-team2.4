package com.horstmann.corejava.lab2;
import java.util.ArrayList;

//если счетом-фактурой считать статистику по всем товарам в наличии, то

public class Task15 {
    public static class Invoice {
        public static class Item { // Открытый вложенный класс private
            String description;
            private int quantity;
            private double unitPrice;

            public Item(String description, int quantity, double unitPrice){
                this.description = description;
                this.quantity = quantity;
                this.unitPrice = unitPrice;
            }
            public double price() { return quantity * unitPrice; }
        }
        private ArrayList<Item> items = new ArrayList<>();

        public void add(Item item) {
            if(item.quantity < 0 || item.unitPrice <= 0) {
                System.out.println("Incorrect data");
                return;
            }
            if(item.description.length() >20) {
                System.out.println("Description is too long");
                return;
            }
            items.add(item);
        }

        public void add(String description, int quantity, double unitPrice) {
            if(quantity < 0 || unitPrice <= 0) {
                System.out.println("Incorrect data");
                return;
            }
            if(description.length() >20) {
                System.out.println("Description is too long");
                return;
            }
            Item newltem = new Item(description,quantity,unitPrice);
            items.add(newltem);
        }

        public void total(){//счет-фактура
            double totalPrice = 0;
            int totalAmount = 0;
            System.out.println("Description:        Quantity:           Unit price:           Total price:");
            //размеры отступов подгоняются чтобы выглядело красиво
            //размер одного "блока" с информацией - 20 пробелов
            for(Item item : items){
                System.out.print(item.description);
                for(int i=0;i<20-item.description.length();i++)
                    System.out.print(' ');

                System.out.print(item.quantity);
                for(int i=0;i<20-String.valueOf(item.quantity).length();i++)
                    System.out.print(' ');

                System.out.print(item.unitPrice);
                for(int i=0;i<20-(int) (Math.log10(item.unitPrice) + 1);i++)
                    System.out.print(' ');

                System.out.print(item.price() + "\n");
                totalPrice+=item.price();
                totalAmount+=item.quantity;
            }
            System.out.println("Total price: " +  totalPrice);
            System.out.println("Total amount: " +  totalAmount);
        }
    }
    public static void main(String[] args){
        Invoice invoice = new Invoice();
        Invoice.Item newItem = new Invoice.Item ("Product1", 5, 100);
        invoice.add(newItem);
        invoice.add("Product2", 2, 150);
        invoice.total();
    }
}
