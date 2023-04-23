package com.horstmann.corejava.lab4.task6;

import java.util.Objects;



public class DiscountedItem extends Item {
    private double discount;

    public DiscountedItem(String description, double price, double discount) {
        super(description, price);
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o))
            return false;
        if (o.getClass() == Item.class) {
            return true;
        }
        DiscountedItem that = (DiscountedItem) o;
        return Double.compare(that.discount, discount) == 0;

    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount);
    }
}
