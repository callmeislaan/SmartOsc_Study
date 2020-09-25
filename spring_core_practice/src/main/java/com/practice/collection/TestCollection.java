package com.practice.collection;

import java.time.LocalDate;
import java.util.function.Predicate;

class A {
    public static void main(String[] args) {
    }

    static boolean test(Predicate<Integer> predicate) {
        return predicate.test(5);
    }
}