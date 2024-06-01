package com.functional_java.chapter3;

import java.util.function.Function;

public class main {

    public static void main(String[] args) {
        Compositor<String, Integer> countingA = new CountingA();

        Function<String, Integer> countingAMethod = countingA.compose(String::toLowerCase);
        System.out.println(countingAMethod.apply("DDDA"));

    }

}
