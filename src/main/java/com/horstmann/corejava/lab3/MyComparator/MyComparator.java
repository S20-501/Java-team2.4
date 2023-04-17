package com.horstmann.corejava.lab3.MyComparator;


import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public interface MyComparator<T> extends Comparator<T> {
    int compare(T first, T second);
    @Override
    default Comparator<T> reversed() {
        return (first, second) -> compare(second, first);
    }

    @Override
    default Comparator<T> thenComparing(Comparator<? super T> other) {
        return (first, second) -> {
            int result = compare(first, second);
            if(result == 0){
                return other.compare(first, second);
            } else{
                return result;
            }
        };
    }

    @Override
    default <U> Comparator<T> thenComparing(Function<? super T, ? extends U> extractor, Comparator<? super U> comparator) {
        return (first, second) -> {
            int result = compare(first, second);
            if(result == 0){
                return comparator.compare(extractor.apply(first), extractor.apply(second));
            } else{
                return result;
            }
        };
    }

    @Override
    default <U extends Comparable<? super U>> Comparator<T> thenComparing(Function<? super T, ? extends U> extractor) {
        return (first, second) -> {
            int result = compare(first, second);
            if(result == 0){
                return extractor.apply(first).compareTo(extractor.apply(second));
            } else{
                return result;
            }
        };
    }

    @Override
    default Comparator<T> thenComparingInt(ToIntFunction<? super T> extractor) {
        return (first, second) -> {
            int result = compare(first, second);
            if(result == 0){
                return Integer.compare(extractor.applyAsInt(first), extractor.applyAsInt(second));
            } else{
                return result;
            }
        };
    }

    @Override
    default Comparator<T> thenComparingLong(ToLongFunction<? super T> extractor) {
        return (first, second) -> {
            int result = compare(first, second);
            if(result == 0){
                return Long.compare(extractor.applyAsLong(first), extractor.applyAsLong(second));
            } else{
                return result;
            }
        };
    }

    @Override
    default Comparator<T> thenComparingDouble(ToDoubleFunction<? super T> extractor) {
        return (first, second) -> {
            int result = compare(first, second);
            if(result == 0){
                return Double.compare(extractor.applyAsDouble(first), extractor.applyAsDouble(second));
            } else{
                return result;
            }
        };
    }

    static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
        return (first, second) -> second.compareTo(first);
    }

    static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        return (first, second) -> first.compareTo(second);
    }

    static <T> Comparator<T> nullsFirst(Comparator<? super T> comparator) {
        return (first, second) -> {
            if(first == null) return -1;
            if(second == null) return 1;
            return comparator.compare(first, second);
        };
    }

    static <T> Comparator<T> nullsLast(Comparator<? super T> comparator) {
        return (first, second) -> {
            if(first == null) return 1;
            if(second == null) return -1;
            return comparator.compare(first, second);
        };
    }

    static <T, U> Comparator<T> comparing(Function<? super T, ? extends U> extractor, Comparator<? super U> comparator) {
        return (first, second) -> comparator.compare(extractor.apply(first), extractor.apply(second));
    }

    static <T, U extends Comparable<? super U>> Comparator<T> comparing(Function<? super T, ? extends U> extractor) {
        return (first, second) -> extractor.apply(first).compareTo(extractor.apply(second));
    }

    static <T> Comparator<T> comparingInt(ToIntFunction<? super T> extractor) {
        return (first, second) -> Integer.compare(extractor.applyAsInt(first), extractor.applyAsInt(second));
    }

    static <T> Comparator<T> comparingLong(ToLongFunction<? super T> extractor) {
        return (first, second) -> Long.compare(extractor.applyAsLong(first), extractor.applyAsLong(second));
    }

    static <T> Comparator<T> comparingDouble(ToDoubleFunction<? super T> extractor) {
        return (first, second) -> Double.compare(extractor.applyAsDouble(first), extractor.applyAsDouble(second));
    }
}
