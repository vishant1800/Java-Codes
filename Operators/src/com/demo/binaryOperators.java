package com.demo;

public class binaryOperators {
    public static void main(String args[]){
        //Arithmetic Operators
        int a = 10, b = 4;

        System.out.println("Arithmetic Operators");
        System.out.println("a + b = " + (a+b));
        System.out.println("a - b = " + (a-b));
        System.out.println("a * b = " + (a*b));
        System.out.println("a / b = " + ((float) a/b));
        System.out.println("a % b = " + (a%b));

        System.out.println("\nRelational Operators");
        System.out.println("a == b " + (a==b));
        System.out.println("a > b " + (a>b));
        System.out.println("a < b " + (a<b));
        System.out.println("a >= b " + (a>=b));
        System.out.println("a <= b " + (a<=b));
        System.out.println("a != b " + (a!=b));

        System.out.println("\nAssignment Operators");
        int c = 4; //Assignment
        System.out.println("c = " + c);
        c += 6; //Add and Assign
        System.out.println("c += 6 " + "c = " + c);
        c -= 2; //Subtract and Assign
        System.out.println("c -= 2 " + "c = " + c);
        c *= 5; //Multiply and Assign
        System.out.println("c *= 5 " + "c = " + c);
        c /= 4; //Divide and Assign
        System.out.println("c /= 4 " + "c = " + c);
        c %= 2; //Modulo and Assign
        System.out.println("c %= 2 " + "c = " + c);

        System.out.println("\nLogical Operators");
        boolean val1 = true;
        boolean val2 = false;
        System.out.println("val1 && val2 = " + (val1 && val2));
        System.out.println("val1 || val2 = " + (val1 || val2));

        System.out.println("\nBitwise Operator");
        int p1 = 10, p2 = 7;
        System.out.println("p1 & p2 = " + (p1&p2));
        System.out.println("p1 | p2 = " + (p1|p2));
        System.out.println("p1 ^ p2 = " + (p1^p2));
        System.out.println("p1 >> 2 = " + (p1 >> 2));
        System.out.println("p1 << 3 = " + (p1 << 3));
    }
}
