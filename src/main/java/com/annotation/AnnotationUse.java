package com.annotation;

@MyAnnotation
public class AnnotationUse {
    public static void main(String[] args) {
        if(AnnotationUse.class.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation myAnnotation = AnnotationUse.class.getAnnotation(MyAnnotation.class);
            System.out.println(myAnnotation);
        }
    }
}
