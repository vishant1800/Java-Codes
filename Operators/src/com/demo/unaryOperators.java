package com.demo;

public class unaryOperators {
    public static void main(String[] args) {
        //Unary Operators
        int a = 10;
        boolean b = true;

        System.out.println("+a = " + +a);
        System.out.println("-a = " + -a);
        System.out.println("a++ = " + a++);
        System.out.println("++a = " + ++a);
        System.out.println("a-- = " + a--);
        System.out.println("--a = " + --a);
        //Logical Not Operator
        System.out.println("!b = " + !b);
        //Bitwise  Operator
        System.out.println("~a = " + ~a); //~a = (~(~a) + 1) = ~(a + 1)

    }
}
