package com.base.lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//lambda表达式必须是函数式接口，而函数式接口代表只能含有一个抽象方法的接口。
//函数式接口可以包含多个默认方法，类方法，但只能声明一个抽象方法。
//如果采用匿名类型内部类来创建函数式接口的实例，则只需要实现一个抽象方法，在这种情况下即可采用lambda表达式来创建对象，
//该表达式创建出来的对象目标就是这个函数接口。
//（可以用@FunctionalInterface注解来对函数接口实行限制）
public class Person {
    public enum Sex {
        MALE, FEMALE
    }
    @FunctionalInterface
    interface CheckPerson {
        int test(Person p);
        // void calcu(Person p);
    }

    interface Predicate<T> {
        boolean test(T t);
    }

    class CheckPersonEligibleForSelectiveService implements CheckPerson {
        public int test(Person p) {
            return p.getAge();
        }

        public void calcu(Person p) {
            p.name = "测试";
        }
    }

    String name;
    LocalDate birthday = LocalDate.now() ;
    Sex gender;
    String emailAddress;

    public int getAge() {
        // ...
        return 20;
    }

    public void printPerson() {
        // ...
        System.out.println(this.birthday);
    }

    public Sex getGender(){
        return this.gender;
    }

    public static void f() {
        Sex.values();
        Sex sex = Sex.FEMALE;
    }

    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsWithinAgeRange(
            List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    public static void printPersons(
            List<Person> roster, CheckPerson tester, Predicate<Person> predicate) {
        for (Person p : roster) {
            if (tester.test(p) == 0) {
                p.printPerson();
            }
            if(predicate.test(p)) {
                System.out.println("great");
            }
        }
    }

    public static void main(String[] args) {
        List<Person> lists = new ArrayList<>();
        lists.add(new Person());
        lists.get(0).gender = Sex.MALE;
//        printPersons(lists, new Person().new CheckPersonEligibleForSelectiveService());
        printPersons(lists,  p -> p.getAge(),  p -> p.getAge() > 16);
    }
}
