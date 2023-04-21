package com.horstmann.corejava.lab3;

import com.horstmann.corejava.lab3.MyComparator.MyComparator;

import java.util.Arrays;
import java.util.Comparator;

public class Additional {
    public static class Comparable{
        private String stringField;
        private double doubleField;
        private int intField;

        public Comparable(String stringField, double doubleField, int intField){
            this.intField = intField;
            this.stringField = stringField;
            this.doubleField = doubleField;
        }

        public double getDoubleField() {
            return doubleField;
        }

        public void setDoubleField(double doubleField) {
            this.doubleField = doubleField;
        }

        public int getIntField() {
            return intField;
        }

        public void setIntField(int intField) {
            this.intField = intField;
        }

        public String getStringField() {
            return stringField;
        }

        public void setStringField(String stringField) {
            this.stringField = stringField;
        }

        @Override
        public String toString() {
            return "Comparable{" +
                    "stringField='" + stringField + '\'' +
                    ", doubleField=" + doubleField +
                    ", intField=" + intField +
                    '}';
        }
    }

    public static class comparator implements MyComparator<Comparable>{
//        @Override
//        public int compare(Object first, Object second) {
//            return -1;
//        }
        public int compare(Comparable first, Comparable second) {

            if(first.getStringField().compareTo(second.getStringField()) != 0)
                return first.getStringField().compareTo(second.getStringField());
            else if(Double.compare(first.getDoubleField(),second.getDoubleField()) != 0)
                return Double.compare(first.getDoubleField(),second.getDoubleField());
            else
                return first.getIntField()-second.getIntField();
        }
    }

    public static void main(String[] args) {
        Comparable array[] = new Comparable[]{
                new Comparable("2",124.123,123),
                new Comparable("2",124.123,124),
                new Comparable("1",123.123,123),
                new Comparable("2",123.123,123),
        };

        Arrays.sort(array,new comparator());

        for(Comparable comp : array){
            System.out.println(comp);
        }
    }
}
