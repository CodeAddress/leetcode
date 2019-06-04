package com.exception;

public class Operators {
    static int aa = 1;

    public static void main(String[] args) {
        System.out.println(aa);
        int aa = 0;
        System.out.println(aa);
    }

    public static void testSwitch() {
        String flag = "flag";
        switch (flag) {
            case "t":
                System.out.println("ooo");
            case "":
                System.out.println("1111");
                break;
        }
    }

    public static void testForStatement() {
        for (char c : "ioio".toCharArray()) {

        }
    }

    public static void increment() {
        ++aa;
    }
}
