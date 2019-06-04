package com.base.string;

public class TestString4 {
    public static void main(String[] args) {
        String str = new String("a");
        String str2 = new String("a");
        final String temp = "a";
        String str3 = "ab";
        String str4 = "a" + "b";
        String str5 = str3 + "c";
        String str6 = str3 + "c";
        System.out.println(str == str2);
        System.out.println(str3 == str4);
        System.out.println(str5 == str6);
        String str7 = temp + "b";
        System.out.println(str4 == str7);
    }
}
