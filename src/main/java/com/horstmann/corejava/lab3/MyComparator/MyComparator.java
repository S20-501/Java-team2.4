package com.horstmann.corejava.lab3.MyComparator;


import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public interface MyComparator<T> extends Comparator<T> {
    int compare(T first, T second);

    default MyComparator<T> reversed() {
        return (first, second) -> compare(second, first);
    }

    default MyComparator<T> thenComparing(MyComparator<? super T> other) {
        return (first, second) -> {
            int result = compare(first, second);
            if(result == 0){
                return other.compare(first, second);
            } else{
                return result;
            }
        };
    }

    default <U> MyComparator<T> thenComparing(Function<? super T, ? extends U> extractor, MyComparator<? super U> comparator) {
        return (first, second) -> {
            int result = compare(first, second);
            if(result == 0){
                return comparator.compare(extractor.apply(first), extractor.apply(second));
            } else{
                return result;
            }
        };
    }

    default <U extends Comparable<? super U>> MyComparator<T> thenComparing(Function<? super T, ? extends U> extractor) {
        return (first, second) -> {
            int result = compare(first, second);
            if(result == 0){
                return extractor.apply(first).compareTo(extractor.apply(second));
            } else{
                return result;
            }
        };
    }

    default MyComparator<T> thenComparingInt(ToIntFunction<? super T> extractor) {
        return (first, second) -> {
            int result = compare(first, second);
            if(result == 0){
                return Integer.compare(extractor.applyAsInt(first), extractor.applyAsInt(second));
            } else{
                return result;
            }
        };
    }

    default MyComparator<T> thenComparingLong(ToLongFunction<? super T> extractor) {
        return (first, second) -> {
            int result = compare(first, second);
            if(result == 0){
                return Long.compare(extractor.applyAsLong(first), extractor.applyAsLong(second));
            } else{
                return result;
            }
        };
    }

    default MyComparator<T> thenComparingDouble(ToDoubleFunction<? super T> extractor) {
        return (first, second) -> {
            int result = compare(first, second);
            if(result == 0){
                return Double.compare(extractor.applyAsDouble(first), extractor.applyAsDouble(second));
            } else{
                return result;
            }
        };
    }

    static <T extends Comparable<? super T>> MyComparator<T> reverseOrder() {
        return (first, second) -> second.compareTo(first);
    }

    static <T extends Comparable<? super T>> MyComparator<T> naturalOrder() {
        return (first, second) -> first.compareTo(second);
    }

    static <T> MyComparator<T> nullsFirst(MyComparator<? super T> comparator) {
        return (first, second) -> {
            if(first == null) return -1;
            if(second == null) return 1;
            return comparator.compare(first, second);
        };
    }

    static <T> MyComparator<T> nullsLast(MyComparator<? super T> comparator) {
        return (first, second) -> {
            if(first == null) return 1;
            if(second == null) return -1;
            return comparator.compare(first, second);
        };
    }

    static <T, U> MyComparator<T> comparing(Function<? super T, ? extends U> extractor, MyComparator<? super U> comparator) {
        return (first, second) -> comparator.compare(extractor.apply(first), extractor.apply(second));
    }

    static <T, U extends Comparable<? super U>> MyComparator<T> comparing(Function<? super T, ? extends U> extractor) {
        return (first, second) -> extractor.apply(first).compareTo(extractor.apply(second));
    }

    static <T> MyComparator<T> comparingInt(ToIntFunction<? super T> extractor) {
        return (first, second) -> Integer.compare(extractor.applyAsInt(first), extractor.applyAsInt(second));
    }

    static <T> MyComparator<T> comparingLong(ToLongFunction<? super T> extractor) {
        return (first, second) -> Long.compare(extractor.applyAsLong(first), extractor.applyAsLong(second));
    }

    static <T> MyComparator<T> comparingDouble(ToDoubleFunction<? super T> extractor) {
        return (first, second) -> Double.compare(extractor.applyAsDouble(first), extractor.applyAsDouble(second));
    }
}
