package com.horstmann.corejava.lab3.extra51;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class MyIterator<T> implements Iterator<T> {

    private List<T> list;
    private int position;

    public MyIterator(List<T> list) {
        this.list = list;
        position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public T next() {
        T element = list.get(position);
        position++;
        return element;
    }

    public static <T> FilteringIterator<T> fromIterator(Iterator<T> iterator) {
        return new FilteringIterator<>(iterator);
    }

}

class FilteringIterator<T> implements Iterator<T> {

    private Iterator<T> iterator;
    private Predicate<T> predicate;
    private T nextElement;
    private boolean hasNext;

    public FilteringIterator(Iterator<T> iterator) {
        this.iterator = iterator;
        this.predicate = (T t) -> true;
        findNextElement();
    }

    public FilteringIterator(Iterator<T> iterator, Predicate<T> predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
        findNextElement();
    }

    private void findNextElement() {
        while (iterator.hasNext()) {
            T element = iterator.next();
            if (predicate.test(element)) {
                nextElement = element;
                hasNext = true;
                return;
            }
        }
        hasNext = false;
    }
    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public T next() {
        T element = nextElement;
        findNextElement();
        return element;
    }
}