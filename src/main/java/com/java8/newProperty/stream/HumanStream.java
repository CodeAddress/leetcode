package com.java8.newProperty.stream;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class HumanStream {
    public static void main(String[] args) {
        Human human1 = new Human("张三",60, 24);
        Human human2 = new Human("李四", 65, 25);
        Human human3 = new Human("王五", 65, 26);
        Human human4 = new Human("赵六", 70, 43);
        Human human5 = new Human("李四", 65, 25);

        List<Human> lists = Arrays.asList(human1,human2,human3,human4,human5);
        List<String> nameList = lists.stream().filter(human -> human.getWeight()>60 && human.getAge() < 30).distinct().sorted((a,b) -> a.getAge() - b.getAge()).map(human -> human.getName()).collect(Collectors.toList());
        nameList.forEach(System.out::println);
    }
}
