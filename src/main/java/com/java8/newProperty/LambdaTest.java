package com.java8.newProperty;

public class LambdaTest {
    final String constant = "sd";

    public static void main(String[] args) {
        LambdaTest test = new LambdaTest();
        MathOperation addOperaton = (int a, int b) -> a + b;
        test.print(3, 4, addOperaton);
        StringLambda operation = s -> System.out.println(s);
        operation.call(test.constant);
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface StringLambda {
        void call(String message);
    }

    private void print(int a, int b, MathOperation operation) {
        System.out.println(operation.operation(a, b));
    }
}
