package com.demo;

public class operators {
    public static void main(String args[]){
        //task1
        int a = 10;
        a--;
        int b = 20;
        System.out.println(a++);
        System.out.println(a);

        System.out.println(++b);
        System.out.println(b++);
        System.out.println(b);

        //task 2
        int x = 20, y = 10, c = 5, d = 3, e = 2;
        int exp = x + y / c - d * e; //precedence of operators concept PEMDAS
        System.out.println(exp);

        //task 3
        int num1 = 5, num2 = 2;
        double res = (double)num1 / num2; //External Typecasting
        // or
//        double res = 5.0 / num2; //Internal Typecasting
        System.out.println("Result is " + res);
        System.out.println(22/7f);
    }
}
