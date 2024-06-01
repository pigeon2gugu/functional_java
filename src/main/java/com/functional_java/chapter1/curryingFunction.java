package com.functional_java.chapter1;

import java.util.function.Function;
import java.util.function.BiFunction;

//해당 설명 글은 https://celdan.tistory.com/45 에 자세히 있습니다.
public class curryingFunction {

    public static BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
    public static BiFunction<Integer, Integer, Integer> minus = (a, b) -> a - b;

    public static BiFunction<BiFunction<Integer, Integer, Integer>, Integer, Function<Integer, Integer>> curry1 = (fx, valueX) -> valueY -> fx.apply(valueX, valueY);

    public static BiFunction<Integer, Integer, Function<BiFunction<Integer, Integer, Integer>, Function<BiFunction<Integer, Integer, Integer>, Integer>>> curry2 = (x, y) ->
            fn -> fn2 -> fn2.apply(fn.apply(x, y), y);

    public static Function<BiFunction<Integer, Integer, Integer>, Function<BiFunction<Integer, Integer, Integer>, Function<Integer, Function<Integer, Integer>>>> curry3  =
            fn -> fn2 -> x -> y -> fn.apply(x, y) + fn2.apply(x, y);

    public static void main(String[] args) {

        //curry1
        System.out.println("===============curry1=================");
        System.out.print("fx: add, valueX : 10, valueY : 5 == ");
        System.out.println(curry1.apply(add, 10).apply(5));

        System.out.print("fx: minus, valueX : 10, valueY : 5 == ");
        System.out.println(curry1.apply(minus, 10).apply(5));

        //curry2
        System.out.println("===============curry2=================");
        System.out.print("(x, y) : (3, 4), fn : add, fn2 : minus == ");
        System.out.println(curry2.apply(3, 4).apply(add).apply(minus));

        //curry3
        System.out.println("===============curry3=================");
        System.out.print("fn : add, fn2 : minus, x : 3, y : 5 = ");
        System.out.println(curry3.apply(add).apply(minus).apply(3).apply(5));
        System.out.println(curry3.apply(add) instanceof Function<BiFunction<Integer, Integer, Integer>, Function<Integer, Function<Integer, Integer>>>);
        System.out.println(curry3.apply(add).apply(minus) instanceof Function<Integer, Function<Integer, Integer>>);
        System.out.println(curry3.apply(add).apply(minus).apply(3) instanceof Function<Integer, Integer>);
        System.out.println(curry3.apply(add).apply(minus).apply(3).apply(5) instanceof Integer);

    }

}
