package com.java8.newProperty.default_mthod;

public interface Vehicle {
    default void print() {
        System.out.println("I'm a car!");
    }
}
