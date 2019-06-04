package com.base;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Constants {
    public static final String USER_HOME = "user.home";
    public static final String USER_DIR = "user.dir";
    public static final String OS_NAME = "os.name";

    public Constants(){}

    public static String[] values() {
        Field[] fields = Constants.class.getFields();
        String[] s = new String[fields.length];
        for(int i=0,n=fields.length; i<n; i++) {
            try {
                Field f = fields[i];
                s[i] = (String) f.get(null);
            } catch (Exception ex) {
                Logger.getLogger(Constants.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return s;
    }

    public static Set<String> asSet() {
        return new HashSet<String>(Arrays.asList(values()));
    }

    public static void main(String[] args) {
        System.out.println("values="+ Arrays.asList(values()));
        System.out.println("set="+asSet());
        Inner inner = new Constants().new Inner();
        Static_Inner static_inner = new Static_Inner();
        System.out.println(Inner.b);
        System.out.println(static_inner.a);
        Constants.Static_Inner static_inner1 = new Constants.Static_Inner();
        Constants.Inner inner1 = new Constants().new Inner();
    }

    public class Inner_Pulic {}

    class Inner {
        private int a = 0;
        static final int b = 0;
        // static int c = 0; inner class cannot define static field but static final
        protected int d = 0;
        int e = Static_Inner.b;
    }

    private static class Static_Inner{
        private int a = 0;
        static final int b =0;
        static int c = 0; //StaticNestedClass
        protected int d = 0;
        int e = 0;
    }

    protected int protected_a = 0;
    int package_a = 0;

    protected void pro_method(){}
    void package_method(){}
}

final class TestOuter {}
