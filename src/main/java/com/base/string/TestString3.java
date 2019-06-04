package com.base.string;

public class TestString3 {
    public static void main(String[] args) {
        String str = "ooo";
        change(str);
        System.out.println(str);
    }

    public static void change(String str){
        str.replace('o', 'p');
    }
}
