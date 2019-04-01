package com.java8.newProperty.default_mthod;

public class Car implements Vehicle,FourVehicle{
    //实现的接口必须为public
    @Override
    public void print() {
        System.out.println("what can I do something");
    }
}
