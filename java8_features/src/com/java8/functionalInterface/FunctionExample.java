package com.java8.functionalInterface;

import java.util.function.Function;

public class FunctionExample {
    static Function<String, String> f1=(name)->{return name.toUpperCase();};
    static Function<String, String> addString=(str1)->{return str1.toUpperCase().concat("default");};

    public static void main(String[] args) {

        System.out.println("Calling uppercase function: "+f1.apply("java8"));
        System.out.println("Calling uppercase and then addstring function: "+f1.andThen(addString).apply("java8"));
        System.out.println("Calling addstring and then uppercase function: "+f1.compose(addString).apply("java8"));
    }
}
