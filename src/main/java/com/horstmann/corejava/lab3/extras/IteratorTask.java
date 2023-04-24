package com.horstmann.corejava.lab3.extras;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class IteratorTask {
    static class MyIterator<E> implements java.util.Iterator<E> {
        public java.util.Iterator<E> iterator;

        public MyIterator(java.util.Iterator<E> iterator){
            this.iterator = iterator;
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public E next() {
            return iterator.next();
        }

        @Override
        public void remove() {
            iterator.remove();
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            iterator.forEachRemaining(action);
        }

        public static <E> MyIterator<E> fromIterator(java.util.Iterator<E> iterator){
            return new MyIterator<>(iterator);
        }

        <K> Map<K, List<E>> collectToMap(Function<E, K> func){
            Map<K, List<E>> map = new HashMap<>();

            while (iterator.hasNext()) {
                E element = iterator.next();
                K key = func.apply(element);

                if (map.containsKey(key)){
                    map.get(key).add(element);
                } else {
                    List<E> list = new ArrayList<>();
                    list.add(element);
                    map.put(key, list);
                }
            }

            return map;
        }

        public ArrayList<E> collect() {
            ArrayList<E> list = new ArrayList<>();

            while (iterator.hasNext()) {
                list.add(iterator.next());
            }

            return list;
        }
    }

    static class TableEntry{
        int id;
        String value;

        public TableEntry(int id, String value) {
            this.id = id;
            this.value = value;
        }

        @Override
        public String toString() {
            return "TableEntry{" +
                    "id=" + id +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<TableEntry> tableList = new ArrayList<>();

        TableEntry commonTableentry = new TableEntry(0, "Common");

        tableList.add(new TableEntry(1, "Foo"));
        tableList.add(new TableEntry(2, "Bar"));
        tableList.add(commonTableentry);
        tableList.add(new TableEntry(3, "Baz"));
        tableList.add(commonTableentry);

        MyIterator<TableEntry> iterator = MyIterator.fromIterator(tableList.iterator());

        Map<Integer, List<TableEntry>> map = iterator.collectToMap(tableEntry -> tableEntry.id);

        System.out.println(map);


        MyIterator<TableEntry> iterator1 = new MyIterator<>(tableList.listIterator(1));

        ArrayList<TableEntry> tableEntries = iterator1.collect();
        System.out.println(tableEntries);
    }
}
