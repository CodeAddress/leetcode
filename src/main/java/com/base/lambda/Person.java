package com.base.lambda;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Supplier;

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
    LocalDate birthday = LocalDate.now();
    Sex gender;
    String emailAddress;

    public int getAge() {
        // ...
        return 20;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void printPerson() {
        // ...
        System.out.println(this.birthday);
    }

    public Sex getGender() {
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
            if (predicate.test(p)) {
                System.out.println("great");
            }
        }
    }

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>>
    DEST transferElements(
            SOURCE sourceCollection,
            Supplier<DEST> collectionFactory) {

        DEST result = collectionFactory.get();
        for (T t : sourceCollection) {
            result.add(t);
        }
        return result;
    }

    private static class ComparisonProvider {
        public int compareByName(Person a, Person b) {
            return a.getName().compareTo(b.getName());
        }

        public int compareByAge(Person a, Person b) {
            return a.getBirthday().compareTo(b.getBirthday());
        }
    }

    public static void main(String[] args) {
        List<Person> lists = new ArrayList<>();
        lists.add(new Person());
        lists.add(new Person());
        Person[] arr = new Person[lists.size()];
        Person[] rosterAsArray = lists.toArray(arr);
        // 第一个参数必须是数组(需要先把list转换成array)
        // 满足参数类型和个数以及返回类型一致方可
        Arrays.sort(rosterAsArray, (a, b) -> Person.compareByAge(a, b));
        Arrays.sort(rosterAsArray, Person::compareByAge);
        ComparisonProvider myComparisonProvider = new Person.ComparisonProvider();
        Arrays.sort(arr, myComparisonProvider::compareByName);
        System.out.println(arr == rosterAsArray);
        lists.get(0).gender = Sex.MALE;
        //        printPersons(lists, new Person().new CheckPersonEligibleForSelectiveService());
        printPersons(lists, p -> p.getAge(), p -> p.getAge() > 16);

        String[] stringArray = { "Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda" };
        Arrays.sort(stringArray, String::compareToIgnoreCase);
        Set<Person> rosterSet = transferElements(lists, () -> new HashSet<>());
        Set<Person> set = transferElements(lists, HashSet::new);
    }
}
