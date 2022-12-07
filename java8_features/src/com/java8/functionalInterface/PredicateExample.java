package com.java8.functionalInterface;

import java.util.function.Predicate;

public class PredicateExample {

    static Predicate<Integer> p1=(i)-> {return i%2==0;};
    static Predicate<Integer> p2=(i)-> {return i%5==0;};

    public static void predicateAnd(){
        System.out.println("p1 AND p2: "+p1.and(p2).test(10));
    }
    public static void predicateOr(){
        System.out.println("p1 OR p2: "+p1.or(p2).test(8));
    }
    public static void predicateNegate(){
        System.out.println("p1 OR p2: "+p1.or(p2).negate().test(8));
    }
    public static void main(String[] args) {

        predicateAnd();
        predicateOr();
        predicateNegate();
    }
}
