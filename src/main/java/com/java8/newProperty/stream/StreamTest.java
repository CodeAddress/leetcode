package com.java8.newProperty.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<String> lists = Arrays.asList("fd","dsd","fff","uuu","opo","fffffd");
        System.out.println("this is filter");
        filter(lists);
        System.out.println("this is map");
        map(lists);

        System.out.println("Test the Integer");
        List<Integer> numbers = Arrays.asList(3, 4, 2, 1, 7, 8, 5);
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        squaresList.forEach(StreamTest::print);
    }

    public static void filter(List<String> lists){
        lists.stream().filter(str -> str.length() > 2).collect(Collectors.toList());
        lists.forEach(StreamTest::print);
        System.out.println();
    }

    //distinct用来去重
    public static void map(List<String> lists) {
        lists.stream().map(eachOne -> eachOne.substring(1)).distinct().collect(Collectors.toList());
        lists.forEach(StreamTest::print);
        System.out.println();
    }

    public static void print(Object str) {
        System.out.print(str + "\t");
    }
}
