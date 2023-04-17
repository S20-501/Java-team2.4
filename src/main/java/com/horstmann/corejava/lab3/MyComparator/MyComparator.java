package com.horstmann.corejava.lab3.MyComparator;


import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public interface MyComparator<T> extends Comparator<T> {
    @Override
    default Comparator<T> reversed() {
        return Comparator.super.reversed();
    }

    @Override
    default Comparator<T> thenComparing(Comparator<? super T> other) {
        return Comparator.super.thenComparing(other);
    }

    @Override
    default <U> Comparator<T> thenComparing(Function<? super T, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return Comparator.super.thenComparing(keyExtractor, keyComparator);
    }

    @Override
    default <U extends Comparable<? super U>> Comparator<T> thenComparing(Function<? super T, ? extends U> keyExtractor) {
        return Comparator.super.thenComparing(keyExtractor);
    }

    @Override
    default Comparator<T> thenComparingInt(ToIntFunction<? super T> keyExtractor) {
        return Comparator.super.thenComparingInt(keyExtractor);
    }

    @Override
    default Comparator<T> thenComparingLong(ToLongFunction<? super T> keyExtractor) {
        return Comparator.super.thenComparingLong(keyExtractor);
    }

    @Override
    default Comparator<T> thenComparingDouble(ToDoubleFunction<? super T> keyExtractor) {
        return Comparator.super.thenComparingDouble(keyExtractor);
    }

    static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
        return Comparator.reverseOrder();
    }

    static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        return Comparator.naturalOrder();
    }

    static <T> Comparator<T> nullsFirst(Comparator<? super T> comparator) {
        return Comparator.nullsFirst(comparator);
    }

    static <T> Comparator<T> nullsLast(Comparator<? super T> comparator) {
        return Comparator.nullsLast(comparator);
    }

    static <T, U> Comparator<T> comparing(Function<? super T, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return Comparator.comparing(keyExtractor, keyComparator);
    }

    static <T, U extends Comparable<? super U>> Comparator<T> comparing(Function<? super T, ? extends U> keyExtractor) {
        return Comparator.comparing(keyExtractor);
    }

    static <T> Comparator<T> comparingInt(ToIntFunction<? super T> keyExtractor) {
        return Comparator.comparingInt(keyExtractor);
    }

    static <T> Comparator<T> comparingLong(ToLongFunction<? super T> keyExtractor) {
        return Comparator.comparingLong(keyExtractor);
    }

    static <T> Comparator<T> comparingDouble(ToDoubleFunction<? super T> keyExtractor) {
        return Comparator.comparingDouble(keyExtractor);
    }
}
