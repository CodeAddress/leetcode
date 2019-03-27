package com.java8.newProperty;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalInterfaces {


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        eval(list, n -> true);
        System.out.println();
        eval(list, n -> n % 2 == 0);
        System.out.println();
        list.stream().filter(n -> n < 4).forEach(System.out::print);
    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {
            if (predicate.test(n)) {
                System.out.print(n + "\t");
            }
        }
    }
}