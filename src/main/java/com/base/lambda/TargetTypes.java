package com.base.lambda;

public class TargetTypes {
    void invoke(Runnable r) {
        r.run();
    }

    <T> T invoke(Callable<T> c) {
        return c.call();
    }

    public static void main(String[] args) {
        TargetTypes types = new TargetTypes();
        types.invoke(() -> "done");
        types.invoke(() -> System.out.println("fdf"));
    }
}

interface Runnable {
    void run();
}
interface Callable<V> {
    V call();
}