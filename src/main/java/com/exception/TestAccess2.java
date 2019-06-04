package com.exception;

public class TestAccess2 {
    final int a;
    final static int b = 9;
    static int c;
    public TestAccess2(int a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Circle circle = new Circle(9,8);
        System.out.println(c);
    }
}
