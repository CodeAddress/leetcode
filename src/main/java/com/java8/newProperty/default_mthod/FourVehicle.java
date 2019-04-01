package com.java8.newProperty.default_mthod;

public interface FourVehicle {
    default void print(){
        System.out.println("I'm a car with four wheels");
    }
}
