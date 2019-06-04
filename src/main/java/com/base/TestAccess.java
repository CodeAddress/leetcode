package com.base;

import com.exception.Circle;

public class TestAccess extends Circle {
    public TestAccess(int x, int y) {
        super(x, y);
    }

    public static void main(String[] args) {
        TestAccess testAccess = new TestAccess(2,4);
        Circle circle = new TestAccess(3,4);
        testAccess.testProtected();
    }
}
