package com.functional_java.chapter3;

import java.util.function.Function;

@FunctionalInterface
public interface Compositor<T, R>{

    R apply(T s);

    default <V> Function<V, R> compose(Function<V, T> before) {
        return (V s) -> {
            T result = before.apply(s);
            return apply(result);
        };
    }

}
