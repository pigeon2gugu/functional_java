package com.functional_java.chapter2;

import java.util.function.Predicate;

public class LambdaPractice {
    interface LikePredicate<T> {
        boolean test(T value);
    }

    static LikePredicate<String> isNull = value -> value == null;
    static Predicate<String> isNull2 = value -> {
            return value == null;
    };
    //compile error
    //Predicate<String> wontCompile = isNull;

    public static void main(String[] args) {
        System.out.println(isNull.test("isNull"));
        System.out.println(isNull2.test("isNull"));
    }
}
