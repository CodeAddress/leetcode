package com.java8.newProperty.stream;

public class Human {
    private String name;
    private int weight;
    private int age;
    //只有实现了equals和hashCode方法,stream的distinct才会有效
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        if (weight != human.weight) return false;
        if (age != human.age) return false;
        return name.equals(human.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + weight;
        result = 31 * result + age;
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Human(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }
}
