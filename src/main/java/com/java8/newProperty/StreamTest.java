package com.java8.newProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
public class StreamTest {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList();
        List<String> list2 = new ArrayList();
        list1.add("1");
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("1");
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("1");
        list1.add("1");
        list1.add("2");
        list1.add("3");

        String tt = list1.stream().parallel().reduce("tt", new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) {
                return s.concat(s2);
            }
        }, new BinaryOperator<String>() {
            @Override
            public String apply(String s, String s2) {
                return s.concat(s2);
            }
        });
        System.out.println(tt);
    }
}
