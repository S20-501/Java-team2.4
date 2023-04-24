package com.horstmann.corejava.lab3.extra51;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class MyIterator<T> implements Iterator<T> {
    private Iterator<T> iterator;

    public MyIterator(Iterator<T> iterator) {
        this.iterator = iterator;
    }

    public static <T> FilteringIterator<T> fromIterator(Iterator<T> iterator) {
        return new FilteringIterator<>(new MyIterator<>(iterator));
    }

/*    public Map<K, List<E>> collectToMap(Function<E, K> func) {
        Map<K, List<E>> map = new HashMap<>();
        while (iterator.hasNext()) {
            E element = iterator.next();
            K key = func.apply(element);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(element);
        }
        return map;
    }*/

    public ArrayList<T> collect() {
        ArrayList<T> list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public T next() {
        return iterator.next();
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