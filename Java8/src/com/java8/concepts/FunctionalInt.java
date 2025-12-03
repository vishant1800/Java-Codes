package com.java8.concepts;


public interface FunctionalInt {
    public void test();
}

@FunctionalInterface
interface demo extends FunctionalInt {
//    public void test2(); //this will throw error because Functional Interface can have only one abstract method
}
