package com.example.softwarearchitecttest2backend.Utils;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

//This class is being used to check null inside service layer or Product
public class NullGuard {


    public static <T> void updateIfPresent(Consumer<T> consumer, T value) {
        if (value != null){
            consumer.accept(value);
        }
    }

    public static <T> void updateIfChanged(Consumer<T> consumer, T value, Supplier<T> supplier) {
        Predicate<T> predicate = input -> !input.equals(value);
        if (value != null && predicate.test(supplier.get())) {
            consumer.accept(value);
        }
    }


}
